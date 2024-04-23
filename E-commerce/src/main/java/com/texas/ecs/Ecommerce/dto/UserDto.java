package com.texas.ecs.Ecommerce.dto;

import com.texas.ecs.Ecommerce.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public class UserDto {

    private Integer Id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String address;
    @Length(max = 10, min = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;
    @NotBlank(message = "E-mail cannot be blank")
    @NotNull(message = "E-mail cannot be null")
    private String email;
    private Role role;

    private String password;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto(Integer id, String address, String name, String phoneNumber, String email) {
        Id = id;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
