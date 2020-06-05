package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IWidgetDefaultValue;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;

/**
 * @author xqw
 * @description:
 * @date 2020/6/5
 */
public class StrWidgetDefaultValue extends WidgetAttributeDefine implements IWidgetDefaultValue<String> {
    private String value;

    public StrWidgetDefaultValue() {
        super("custom", "自定义", WidgetType.TEXT);
    }

    @Override
    public String getDefaultValue() {
        return value;
    }
}
