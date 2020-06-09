package cn.echaincity.workflow.form.widget.define.intf;

import java.util.Map;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
public interface IValidatedFilter {
    boolean needValidate(Map<String, Object> options);

    boolean validate(Object value);
}
