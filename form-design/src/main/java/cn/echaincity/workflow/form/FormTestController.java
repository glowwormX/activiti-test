//package cn.echaincity.workflow.form;
//
//import cn.echaincity.workflow.form.BaseForm;
//import cn.echaincity.workflow.form.service.BaseFormService;
//import cn.echaincity.workflow.form.widget.define.WidgetDefineFactory;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author xqw
// * @description:
// * @date 2020/6/5
// */
//@RestController
//public class FormTestController {
//    @Autowired
//    private BaseFormService baseFormService;
//    @PostMapping("/define/widget")
//    @ApiOperation(value = "define_widget", tags = "define")
//    public List defineWidget(@RequestBody @ApiParam("<a href='json/form.json' target='jsonExample'>例子</a>") String define) {
//        return Arrays.asList(WidgetDefineFactory.buildTextWidget(), WidgetDefineFactory.buildSelectSingleWidget());
//    }
//    @PostMapping("/baseForm/save")
//    @ApiOperation(value = "/baseForm/save", tags = "define")
//    public List formSave(@RequestBody @ApiParam("<a href='json/form.json' target='jsonExample'>例子</a>") BaseForm baseForm) {
//        baseFormService.saveBaseForm(baseForm);
//        return Arrays.asList();
//    }
//}
