package cn.echaincity.workflow.form.dao;

import cn.echaincity.workflow.form.FormValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author xqw
 * @description:
 * @date 2020/6/8
 */
@Service
public class FormValueTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void addFormValue(FormValue formValue) {
        mongoTemplate.insert(formValue, "form_" + formValue.getFormId());
    }
}
