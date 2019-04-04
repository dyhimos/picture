package com.example.demo.model.entry;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="user_base_info")
public class UserBaseInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 5868261466111685585L;
    private String ubiId;
    private String ubiName;
    private String ubiPassword ;
    private String ubiCertType;
    private String ubiCertNo;
    private String ubiMobile;
    private String ubiEmail;
    private String ubiAddress;
    private String ubiLoginName;
}
