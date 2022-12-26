package com.imdev.inticorp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContactResponse {
    
    @JsonProperty("id")
    private String idUserContact;

    private String address;

    private String user;
}
