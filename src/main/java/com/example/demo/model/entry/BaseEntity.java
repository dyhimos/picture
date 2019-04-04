package com.example.demo.model.entry;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
@Data
@Entity
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 5868261466111685585L;
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    @Id
    @Column(
            name = "Id"
    )
    private String id;
    protected String createBy;
    @OrderBy("desc")
    protected Date createDate;
    protected String updateBy;
    protected Date updateDate;
    protected String remarks;
    protected String delFlag = "0";
}
