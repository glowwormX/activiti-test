package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
public class RequiredValidatedFilter extends WidgetAttributeDefine implements IValidatedFilter {
    @Override
    public boolean validate(Object value) {
        return value != null;
    }

    public RequiredValidatedFilter() {
        super("required", "必填", WidgetType.LABEL);
    }
}
