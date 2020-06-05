package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;
import cn.echaincity.workflow.form.widget.define.intf.ISelectValue;

import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/5
 */
public class FormDataSelectValue extends WidgetAttributeDefine implements ISelectValue<List> {
    public FormDataSelectValue() {
        super("formData", "从其他表单数据获取", WidgetType.SELECT_SINGLE);
    }

    @Override
    public List getSelectValue() {
        return null;
    }
}
