package com.imdev.inticorp.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponse extends UserResponse {

    @JsonProperty("user_contact_list")
    private List<UserContactResponse> userContactResponsesList;
}
