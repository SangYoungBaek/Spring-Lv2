package com.sparta.lvtwohomework.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    @Size(min=4, max=10, message = "ID 사이즈가 비정상적입니다.")
    @Pattern(regexp = "(^[0-9a-z]*$)", message = "ID 형식이 올바르지않습니다.")
    private String username;

    @Size(min=8, max=15, message = "패스워드가 비정상적입니다.")
    @Pattern(regexp = "(^[0-9a-zA-Z]*$)",  message = "ID 형식이 올바르지않습니다.")
    private String password;

    private boolean admin = false;
    private String adminToken = "";
}
