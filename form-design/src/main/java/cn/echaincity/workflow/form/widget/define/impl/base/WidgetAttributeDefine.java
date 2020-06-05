package cn.echaincity.workflow.form.widget.define.impl.base;

import cn.echaincity.workflow.form.WidgetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WidgetAttributeDefine {
    private String attributeId;
    private String attributeLabel;
    private WidgetType attributeType;
}
