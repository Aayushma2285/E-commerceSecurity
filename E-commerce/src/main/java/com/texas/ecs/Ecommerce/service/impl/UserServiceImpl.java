package com.texas.ecs.Ecommerce.service.impl;

import com.texas.ecs.Ecommerce.dto.UserDto;
import com.texas.ecs.Ecommerce.exception.UserNotFoundException;
import com.texas.ecs.Ecommerce.model.User;
import com.texas.ecs.Ecommerce.repo.UserRepo;
import com.texas.ecs.Ecommerce.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Integer save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());

        // converting plain password to encoded password :: uses Bcrypt Password Encoder
        String plainPassword = userDto.getPassword();
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);

        user.setRole(userDto.getRole());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepo.findAll();
        List<UserDto> userDtoList = userList.stream()
                .map(user -> {
                    UserDto userDto = new UserDto(
                            user.getId(),user.getName(), user.getAddress(),user.getPhoneNumber(), user.getEmail()
                    );
                    return userDto;
                }).collect(Collectors.toList());
        return userDtoList;

    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

}
