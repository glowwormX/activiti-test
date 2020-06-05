package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;
import cn.echaincity.workflow.form.widget.define.intf.ISelectValue;
import cn.echaincity.workflow.form.widget.instance.WidgetAttributeInstance;

import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/5
 */
public class CustomSelectValue extends WidgetAttributeDefine implements ISelectValue<List<String>>, WidgetAttributeInstance<List<String>> {
    private List<String> instanceValue;

    public CustomSelectValue() {
        super("custom", "自定义", WidgetType.LABEL);
    }

    @Override
    public List getSelectValue() {
        return null;
    }

    @Override
    public List<String> getInstanceValue() {
        return instanceValue;
    }

    @Override
    public List<String> setInstanceValue() {
        return instanceValue;
    }
}
