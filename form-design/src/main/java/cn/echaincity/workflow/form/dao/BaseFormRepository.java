package cn.echaincity.workflow.form.dao;

import cn.echaincity.workflow.form.BaseForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xqw
 * @description:
 * @date 2020/6/8
 */
@Repository
public interface BaseFormRepository extends MongoRepository<BaseForm, String> {
}
