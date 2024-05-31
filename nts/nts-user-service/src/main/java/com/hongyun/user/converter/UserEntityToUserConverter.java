package com.hongyun.user.converter;

import com.hongyun.nts.model.user.User;
import com.hongyun.user.model.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserConverter implements Converter<UserEntity, User> {

    @Override
    public User convert(UserEntity source) {
        User user = new User();
        user.setId(source.getId());
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        user.setEmail(source.getEmail());
        user.setPhone(source.getPhone());
        return user;
    }
}
