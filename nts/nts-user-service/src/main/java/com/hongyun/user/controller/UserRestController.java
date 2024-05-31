package com.hongyun.user.controller;


import com.hongyun.nts.model.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hongyun.user.model.UserEntity;
import com.hongyun.user.service.UserService;

@RestController
public class UserRestController {

    private final UserService userService;
    private ConversionService conversionService;

    public UserRestController(UserService userService,
                              @Qualifier("mvcConversionService") ConversionService conversionService) {
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @RequestMapping("/user")
    public User getUser(
            @RequestParam("username") String username) {
        UserEntity userEntity =  userService.getUserByUsername(username);
        return conversionService.convert(userEntity, User.class);
    }

    @PostMapping("/user")
    public UserEntity addUser(
            @RequestBody User user) {
        UserEntity userEntity = new UserEntity(
                null,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone()
        );
        userEntity = userService.addUser(userEntity);
        return conversionService.convert(userEntity, UserEntity.class);
    }
}
