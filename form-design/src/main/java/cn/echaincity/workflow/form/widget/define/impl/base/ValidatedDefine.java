package cn.echaincity.workflow.form.widget.define.impl.base;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
@Getter
public class ValidatedDefine extends WidgetAttributeDefine {
    private List<IValidatedFilter> filters;

    public ValidatedDefine(List<IValidatedFilter> filters) {
        super("validate", "校验", WidgetType.CHECK_SINGLE);
        this.filters = filters;
    }

    public ValidatedDefine(IValidatedFilter... filters) {
        super("validate", "校验", WidgetType.CHECK_SINGLE);
        this.filters = Arrays.asList(filters);
    }

}
