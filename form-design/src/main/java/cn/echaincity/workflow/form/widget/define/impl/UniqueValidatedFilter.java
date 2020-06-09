package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;

import java.util.Map;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
public class UniqueValidatedFilter extends WidgetAttributeDefine implements IValidatedFilter {
    @Override
    public boolean needValidate(Map<String, Object> options) {
        return false;
    }

    @Override
    public boolean validate(Object value) {
        //TODO
        return true;
    }

    public UniqueValidatedFilter() {
        super("unique", "不可重复", WidgetType.LABEL);
    }
}
