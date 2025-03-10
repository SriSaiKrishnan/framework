package com.sai.api.builder;

import com.sai.api.pojo.Employee;

public class EmployeeBuilder {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
    }

    public EmployeeBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Employee build(){
        return new Employee(this.id, this.firstName, this.lastName, this.email, this.phone);
    }
}
