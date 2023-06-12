package com.example.authorization_service.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
    @NotBlank
    @Size(min=2, max=10)
    private String User;
    @NotBlank
    @Size(min=3, max=15)
    private String password;
}
