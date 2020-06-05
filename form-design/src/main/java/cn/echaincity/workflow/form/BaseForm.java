package cn.echaincity.workflow.form;

import cn.echaincity.workflow.form.widget.BaseWidget;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/3
 */
@Data
public class BaseForm {
    @ApiModelProperty("pc端布局情况 单列 双列")
    private String pcLayout;

    @ApiModelProperty("移动端布局情况 标准版 小字小间距版 大字版等")
    private String appLayout;

    @ApiModelProperty("所有字段")
    private List<BaseWidget> formFields;
}
