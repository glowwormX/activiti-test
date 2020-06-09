package cn.echaincity.workflow.form;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author xqw
 * @description:
 * @date 2020/6/3
 */
@Data
public class FormValue {
    private String formId;
    private String processId;
    private Map<String, Object> values;
    private Date createTime;
    private String createUser;
}
