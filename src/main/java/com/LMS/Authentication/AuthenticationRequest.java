package com.LMS.Authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
