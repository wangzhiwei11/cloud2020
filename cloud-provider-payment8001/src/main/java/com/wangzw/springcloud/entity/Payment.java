package com.wangzw.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangzw
 * @date 2020/4/26 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{
    private String id;
    private String serial;
}
