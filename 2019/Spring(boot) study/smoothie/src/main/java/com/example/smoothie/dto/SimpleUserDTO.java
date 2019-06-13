package com.example.smoothie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String intro;
}
