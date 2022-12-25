package com.imdev.inticorp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DefaultResponse<T> {
    
    private int status;

    private T data;
}
