package cn.echaincity.workflow.form.widget.define;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;
import lombok.*;

import java.util.List;

/**
 * @author xqw
 * @description: 组件
 * @date 2020/6/3
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseWidgetDefine {
    private String label;

    private WidgetType type;

    private List<WidgetAttributeDefine> attributeDefine;

    private Integer status;

}
