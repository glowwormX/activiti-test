package cn.echaincity.workflow.form.widget.instance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
public interface WidgetAttributeInstance<T> {
    T getInstanceValue();

    T setInstanceValue();
}
