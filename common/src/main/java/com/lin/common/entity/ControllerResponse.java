package com.lin.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControllerResponse {
    private String code;
    private String message;
    private Object data;

    public ControllerResponse(Object data){
        this.code="200";
        this.message="操作成功!";
        this.data=data;
    }

    public ControllerResponse(String code,Object data){
        this.code=code;
        this.message="操作异常，具体请查询返回编码!";
        this.data=data;
    }
}
