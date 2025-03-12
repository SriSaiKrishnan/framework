package com.sai.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
