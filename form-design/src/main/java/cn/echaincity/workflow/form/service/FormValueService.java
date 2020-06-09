package cn.echaincity.workflow.form.service;

import cn.echaincity.workflow.form.FormValue;
import cn.echaincity.workflow.form.WidgetType;
import cn.echaincity.workflow.form.dao.FormValueTemplate;
import cn.echaincity.workflow.form.widget.BaseWidget;
import cn.echaincity.workflow.form.widget.define.intf.IValidatedFilter;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xqw
 * @description:
 * @date 2020/6/8
 */
@Service
public class FormValueService {
    @Autowired
    private BaseFormService baseFormService;
    @Autowired
    private FormValueTemplate formValueTemplate;

    @Autowired
    private List<IValidatedFilter> validatedFilters;

    public void addFormValue(FormValue formValue) {
        List<BaseWidget> widgetList = baseFormService.findById(formValue.getFormId()).getFormWidgets();
        Map<String, Object> values = formValue.getValues();

        for (BaseWidget widget : widgetList) {
            Object value = values.get(widget.getId());
            handValue(widget, value);

            //表格
            if (WidgetType.TABLE.equals(widget.getType())) {
                if (value instanceof List &&
                        widget.getOptions().get("items") instanceof List) {
                    List cols = (List) widget.getOptions().get("items");
                    for (Object valueRow : ((List) value)) {
                        if (valueRow instanceof List) {
                            for (int i = 0; i < ((List) valueRow).size(); i++) {
                                BaseWidget colsType = new JSONObject((Map<String, Object>) cols.get(i)).toJavaObject(BaseWidget.class);
                                handValue(colsType, ((List) valueRow).get(i));
                            }
                        }
                    }
                }
            }
        }

        formValueTemplate.addFormValue(formValue);
    }

    private void handValue(BaseWidget widget, Object value) {
        //校验过滤器
        for (IValidatedFilter filter : validatedFilters) {
            if (filter.needValidate(widget.getOptions())) {
                filter.validate(value);
            }
        }

        //默认值过滤器
    }

}
