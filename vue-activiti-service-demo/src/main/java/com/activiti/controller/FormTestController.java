package com.activiti.controller;//package cn.echaincity.workflow.form;

import cn.echaincity.workflow.form.BaseForm;
import cn.echaincity.workflow.form.FormValue;
import cn.echaincity.workflow.form.dao.FormValueTemplate;
import cn.echaincity.workflow.form.service.BaseFormService;
import cn.echaincity.workflow.form.service.FormValueService;
import cn.echaincity.workflow.form.widget.define.WidgetDefineFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/5
 */
@RestController
public class FormTestController {
    @Autowired
    private BaseFormService baseFormService;
    @Autowired
    private FormValueService formValueService;

    @PostMapping("/define/widget")
    public List defineWidget(@RequestBody String define) {
        return Arrays.asList(WidgetDefineFactory.buildTextWidget(), WidgetDefineFactory.buildSelectSingleWidget());
    }

    @PostMapping("/baseForm/save")
    public List formSave(@RequestBody @ApiParam("<a href='json/form.json' target='jsonExample'>例子</a>") BaseForm baseForm) {
        baseFormService.saveBaseForm(baseForm);
        return Arrays.asList();
    }

    @PostMapping("/formValue/save")
    public List formValueSave(@RequestBody @ApiParam("<a href='json/formValue.json' target='jsonExample'>例子</a>") FormValue formValue) {
        formValueService.addFormValue(formValue);
        return Arrays.asList();
    }
}
