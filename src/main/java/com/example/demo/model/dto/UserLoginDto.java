package com.example.demo.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
@Data
@ApiModel(value="登录")
public class UserLoginDto implements Serializable {

    private static final long serialVersionUID = 3319698607712846427L;

    @ApiModelProperty(value = "用户登录名")
    private String loginId;

    @ApiModelProperty(value = "密码")
    private String password;
}
