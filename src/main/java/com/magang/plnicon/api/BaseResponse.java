package com.magang.plnicon.api;

import io.micrometer.common.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    private boolean success;
    private String message;
    @JsonIgnoreProperties({"pageable", "sort"})
    private T data;


    public static <T> BaseResponse<T> ok(T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .message("OK")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> ok(String message, T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .message(StringUtils.isNotBlank(message) ? message : "")
                .data(data)
                .build();
    }



    public static <T> BaseResponse<T> error(String message) {
        return BaseResponse.<T>builder()
                .success(false)
                .message(StringUtils.isNotBlank(message) ? message : "")
                .data(null)
                .build();
    }

}
