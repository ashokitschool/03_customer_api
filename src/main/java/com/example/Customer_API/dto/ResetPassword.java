package com.example.Customer_API.dto;

import lombok.Data;

@Data
public class ResetPassword {
    private String newPwd;
    private String confirmNewPwd;
}
