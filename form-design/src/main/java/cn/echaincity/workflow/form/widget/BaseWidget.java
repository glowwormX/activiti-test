package cn.echaincity.workflow.form.widget;

import cn.echaincity.workflow.form.WidgetType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author xqw
 * @description: 组件
 * @date 2020/6/3
 */
@Data
@ApiModel(description = "表单组件 例子：/json/form.json")
public class BaseWidget {
    private String id;
    @ApiModelProperty("标签")
    private String label;
    @ApiModelProperty("表单类型")
    private WidgetType type;
    @ApiModelProperty("描述信息")
    private String description;
    @ApiModelProperty("宽度")
    private String lineWidth;
    @ApiModelProperty("是否可见")
    private Boolean visible;
    @ApiModelProperty("是否可编辑")
    private Boolean editable;
    @ApiModelProperty("表单选项、属性，根据type的一些特殊属性")
    private Map<String, Object> options;
}
