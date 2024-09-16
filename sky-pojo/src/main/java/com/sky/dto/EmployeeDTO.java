package com.sky.dto;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    @Id
    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

}
