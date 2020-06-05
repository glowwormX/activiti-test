package cn.echaincity.workflow.form;

import cn.echaincity.workflow.form.widget.BaseWidget;
import lombok.Data;

/**
 * @author xqw
 * @description:
 * @date 2020/6/3
 */
@Data
public class WidgetValue {
    private BaseWidget form;
    private Object value;
}
