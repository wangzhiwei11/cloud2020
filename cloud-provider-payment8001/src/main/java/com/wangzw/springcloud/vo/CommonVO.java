package com.wangzw.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangzw
 * @date 2020/4/26 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonVO<T> {

    private boolean success;
    private String message;
    private T data;

    public CommonVO(boolean success, String message) {
        this(success, message, null);
    }
}
