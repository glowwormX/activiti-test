package cn.echaincity.workflow.form.widget.define;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.impl.*;
import cn.echaincity.workflow.form.widget.define.impl.base.DefaultValueDefine;
import cn.echaincity.workflow.form.widget.define.impl.base.SelectItemsDefine;
import cn.echaincity.workflow.form.widget.define.impl.base.ValidatedDefine;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xqw
 * @description:
 * @date 2020/6/5
 */
public class WidgetDefineFactory {


    public static List<WidgetAttributeDefine> createBaseAttributeDefine() {
        List<WidgetAttributeDefine> attributeDefines = new ArrayList<>();
        attributeDefines.add(new WidgetAttributeDefine("id", "唯一标识", WidgetType.DISABLE));
        attributeDefines.add(new WidgetAttributeDefine("label", "标题", WidgetType.TEXT));
        attributeDefines.add(new WidgetAttributeDefine("description", "描述信息", WidgetType.TEXT));
        return attributeDefines;

    }

    public static BaseWidgetDefine buildTextWidget() {
        List<WidgetAttributeDefine> attributeDefines = createBaseAttributeDefine();
        attributeDefines.add(new DefaultValueDefine(new StrWidgetDefaultValue()));
        attributeDefines.add(new RegexFormateFilter());
        attributeDefines.add(new ValidatedDefine(new RequiredValidatedFilter(), new UniqueValidatedFilter()));
        return BaseWidgetDefine.builder()
                .label("单行文本")
                .type(WidgetType.TEXT)
                .attributeDefine(attributeDefines)
                .build();
    }

    public static BaseWidgetDefine buildSelectSingleWidget() {
        List<WidgetAttributeDefine> attributeDefines = createBaseAttributeDefine();

        attributeDefines.add(new SelectItemsDefine(new CustomSelectValue(), new FormDataSelectValue()));
        attributeDefines.add(new ValidatedDefine(new RequiredValidatedFilter(), new UniqueValidatedFilter()));
        return BaseWidgetDefine.builder()
                .label("下拉框")
                .type(WidgetType.SELECT_SINGLE)
                .attributeDefine(attributeDefines)
                .build();
    }
}
