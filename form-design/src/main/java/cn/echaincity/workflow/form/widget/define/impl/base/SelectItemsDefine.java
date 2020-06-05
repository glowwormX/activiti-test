package cn.echaincity.workflow.form.widget.define.impl.base;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.intf.ISelectValue;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/5
 */
@Getter
public class SelectItemsDefine extends WidgetAttributeDefine {
    private List<ISelectValue> selectValues;

    public SelectItemsDefine(List<ISelectValue> selectValues) {
        super("selectItems", "下拉选项", WidgetType.SELECT_SINGLE);
        this.selectValues = selectValues;
    }

    public SelectItemsDefine(ISelectValue... selectValues) {
        super("selectItems", "下拉选项", WidgetType.SELECT_SINGLE);
        this.selectValues = Arrays.asList(selectValues);
    }
}
