package cn.echaincity.activiti;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.util.IoUtil;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xqw
 * @description:
 * @date 2020/5/21
 */
@RestController
public class ActivitiTestController {
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Autowired
    ManagementService managementService;
    @Autowired
    IdentityService identityService;
    @Autowired
    FormService formService;


    //部署流程
    @GetMapping("/deployProcess")
    @ApiOperation(value = "部署流程", tags = "init")
    public Deployment deployProcess(String bpmnFileName){
        Deployment deploy = repositoryService.createDeployment()
                .disableSchemaValidation()
//                .addBpmnModel()
                .addClasspathResource(bpmnFileName)//bpmn文件的名称
                .name("请假流程")
                .category("行政")
                .deploy();
        System.out.println("部署的id"+deploy.getId());
        System.out.println("部署的名称"+deploy.getName());
        return deploy;
    }

    @GetMapping("/createMembership")
    @ApiOperation(value = "用户分组", tags = "identity")
    public String createMembership(String user, String group) {
        identityService.createMembership(user, group);
        return "success";
    }

    @GetMapping("/newUser")
    @ApiOperation(value = "创建用户", tags = "identity")
    public String newUser(String user) {
        User user1 = identityService.newUser(user);
        identityService.saveUser(user1);
        return "success";
    }

    @GetMapping("/newGroup")
    @ApiOperation(value = "创建组", tags = "identity")
    public String newGroup(String group) {
        Group group1 = identityService.newGroup(group);
        identityService.saveGroup(group1);
        return "success";
    }

    //启动流程
    @PostMapping("/startProcess")
    @ApiOperation(value = "启动流程", tags = "process")
    public String startProcess(String key, @RequestBody Map<String, Object> vars){
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(key, vars);//流程的名称，也可以使用ByID来启动流程
        System.out.println("流程实例id:"+pi.getId());//流程实例id
        System.out.println("流程定义id:"+pi.getProcessDefinitionId());//输出流程定义的id
        return pi.toString();
    }


    @PostMapping("/compileTask")
    @ApiOperation(value = "完成一个任务", tags = "process")
    public void compileTask(String taskId, @RequestBody Map<String, Object> vars){
        taskService.complete(taskId, vars);
    }


    @GetMapping("/queryTask")
    @ApiOperation(value = "查询流程", tags = "process")
    public List<Map<String, Object>> queryTaskByAssignee(String userIdForCandidateAndAssignee, String processInstanceId, String group){
        TaskQuery query = taskService.createTaskQuery();
        if (userIdForCandidateAndAssignee != null) {
            query.taskCandidateOrAssigned(userIdForCandidateAndAssignee);
        }
        if (processInstanceId != null) {
            query.processInstanceId(processInstanceId);
        }
        if (group != null) {
            query.taskCandidateGroup(group);
        }
        return convertTask(query.list());
    }

    @GetMapping("/queryTaskByVariableValue")
    @ApiOperation(value = "查询流程-根据变量", tags = "process")
    public List<Map<String, Object>> queryTaskByAssignee(String key, String value){
        List<Task> tasks = taskService.createTaskQuery()
                .processVariableValueEquals(key, value)
                .list();

        return convertTask(tasks);
    }

    @GetMapping("/queryHistory")
    @ApiOperation(value = "查询历史", tags = "process")
    public List<HistoricTaskInstance> queryHistory(String deploymentId, String processInstanceId){
        //taskId：任务id
        HistoricTaskInstanceQuery query = historyService
                .createHistoricTaskInstanceQuery();
        if(deploymentId != null) {
            query.deploymentId(deploymentId);
        }
        if(processInstanceId != null) {
            query.processInstanceId(processInstanceId);
        }
        return query.list();
    }

    public List<Map<String, Object>> convertTask(List<Task> tasks) {
        List<Map<String, Object>> res = new ArrayList<>();
        for (Task task : tasks) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", task.getId());
            map.put("name", task.getName());
            map.put("assignee", task.getAssignee());
//            map.put("processVariables", task.getProcessVariables());
            map.put("runtimeService.getVariables", runtimeService.getVariables(task.getExecutionId()));
            map.put("parentTaskId", task.getParentTaskId());
            map.put("createTime", task.getCreateTime());
//            map.put("taskLocalVariables", task.getTaskLocalVariables());
//            map.put("runtimeService.getVariablesLocal", runtimeService.getVariablesLocal(task.getExecutionId()));
            res.add(map);
        }
        return res;
    }

    @GetMapping("processImage")
    @ApiOperation(value = "流程图片", tags = "init")
    public void processDefinitionImage(String processDefinitionId, HttpServletResponse response) throws IOException {

        if (StringUtils.isBlank(processDefinitionId)) {
            throw new IllegalArgumentException("processDefinitionId 不能为空!");
        }
        InputStream inputStream = this.getDefinitionImage(processDefinitionId);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
    }
    public InputStream getDefinitionImage(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        InputStream inputStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());
        return inputStream;
    }

    @RequestMapping(value = "startForm/{procDefId}")
    public String startForm(@PathVariable(value = "procDefId") String procDefId, Model model) {

        Map<String, Map<String, String>> result = Maps.newHashMap();
        Map<String,String> datePatterns = Maps.newHashMap();
        StartFormData startFormData = formService.getStartFormData(procDefId);
        List<FormProperty> formProperties = startFormData.getFormProperties();
        for (FormProperty formProperty : formProperties) {
            if("enum".equals(formProperty.getType().getName())){
                Map<String, String> values;
                values = (Map<String, String>) formProperty.getType().getInformation("values");
                if (values != null) {
                    for (Map.Entry<String, String> enumEntry : values.entrySet())
//                        logger.debug("enum, key: {}, value: {}", enumEntry.getKey(), enumEntry.getValue());
                    result.put("enum_" + formProperty.getId(), values);
                }

            }else if("date".equals(formProperty.getType().getName())){
                datePatterns.put("pattern_"+formProperty.getId(), (String)formProperty.getType().getInformation("datePattern"));
//                logger.debug("date,key:{},pattern:{}",formProperty.getId(),formProperty.getType().getInformation("datePattern"));
            }

        }
        model.addAttribute("datePatterns",datePatterns);
        model.addAttribute("result", result);
        model.addAttribute("list", formProperties);
        model.addAttribute("formData", startFormData);

        return "modules/act/dynamicStartForm";
    }
}
