package cn.echaincity.workflow.form.service;

import cn.echaincity.workflow.form.BaseForm;
import cn.echaincity.workflow.form.dao.BaseFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author xqw
 * @description:
 * @date 2020/6/8
 */
@Service
public class BaseFormService {
    @Autowired
    private BaseFormRepository baseFormRepository;

    public void saveBaseForm(BaseForm form) {
        baseFormRepository.save(form);
    }

    public BaseForm findById(String id) {
        return baseFormRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("表单不存在"));
    }

    public BaseForm findByIdDetail(String id) {
        BaseForm baseForm = findById(id);
        //默认值过滤器

        //选项过滤器


        return baseForm;
    }
}
