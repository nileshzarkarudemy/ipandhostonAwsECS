package com.ipandhost.iphostecs;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String firstName; 
    private String lastName;
    private String email;
}
