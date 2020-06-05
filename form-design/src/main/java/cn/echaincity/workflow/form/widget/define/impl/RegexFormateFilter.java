package cn.echaincity.workflow.form.widget.define.impl;

import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.widget.define.impl.base.WidgetAttributeDefine;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author xqw
 * @description:
 * @date 2020/6/4
 */
public class RegexFormateFilter extends WidgetAttributeDefine implements IValidatedFilter {
    private static List<String> regexList = Arrays.asList("邮箱", "身份证", "手机", "电话", "邮编");

    private Pattern pattern;

    @Override
    public boolean validate(Object value) {
        //验证 pattern.xxx();
        return true;
    }

    public List<String> getAllRegexList() {
        return regexList;
    }

    public RegexFormateFilter() {
        super("format", "格式", WidgetType.SELECT_SINGLE);
    }
}
