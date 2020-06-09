package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IWidgetDefaultValue;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;
import org.springframework.stereotype.Component;

/**
 * @author xqw
 * @description: 自定义 默认值
 * @date 2020/6/5
 */
@Component
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
