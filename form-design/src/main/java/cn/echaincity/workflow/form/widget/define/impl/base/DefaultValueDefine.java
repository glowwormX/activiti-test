package cn.echaincity.workflow.form.widget.define.impl.base;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IWidgetDefaultValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
@Getter
public class DefaultValueDefine extends WidgetAttributeDefine {
    private List<IWidgetDefaultValue> defaultValues;

    public DefaultValueDefine(List<IWidgetDefaultValue> defaultValues) {
        super("defaultValue", "默认值", WidgetType.CHECK_SINGLE);
        this.defaultValues = defaultValues;
    }

    public DefaultValueDefine(IWidgetDefaultValue... defaultValues) {
        super("defaultValue", "默认值", WidgetType.CHECK_SINGLE);
        this.defaultValues = Arrays.asList(defaultValues);
    }

}
