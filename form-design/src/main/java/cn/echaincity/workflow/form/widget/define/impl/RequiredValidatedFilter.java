package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xqw
 * @description: 必填验证
 * @date 2020/6/4
 */
@Component
public class RequiredValidatedFilter extends WidgetAttributeDefine implements IValidatedFilter {


    @Override
    public boolean needValidate(Map<String, Object> options) {
        Object required = options.get("required");
        if (required instanceof Boolean) {
            return (boolean) required;
        }
        return false;
    }

    @Override
    public boolean validate(Object value) {
        return value != null;
    }

    public RequiredValidatedFilter() {
        super("required", "必填", WidgetType.LABEL);
    }
}
