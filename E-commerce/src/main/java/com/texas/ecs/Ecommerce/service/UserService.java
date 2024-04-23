package com.texas.ecs.Ecommerce.service;

import com.texas.ecs.Ecommerce.dto.UserDto;
import com.texas.ecs.Ecommerce.model.User;

import java.util.List;

public interface UserService {
    Integer save(UserDto userDto);
    UserDto getById(Integer id);
    List<UserDto> getAll();
     void deleteById(Integer id);
     User getUser(Integer id);
}
