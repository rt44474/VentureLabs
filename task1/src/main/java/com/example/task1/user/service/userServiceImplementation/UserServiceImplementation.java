package com.example.task1.user.service.userServiceImplementation;

import com.example.task1.user.dto.UserDto;
import com.example.task1.user.entity.User;
import com.example.task1.user.entity.UserPrincipal;
import com.example.task1.user.mappers.UserMapper;
import com.example.task1.user.repository.UserRepositoryI;
import com.example.task1.user.service.UserServiceI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserServiceI, UserDetailsService {

    @Autowired
    private final UserRepositoryI userRepositoryI;

    protected UserMapper userMapper;

    @Override
    public UserDto findUserByUsername(String username) {
        return this.userMapper.toDto(
                userRepositoryI.findUserByUsername(username)
        );
    }

    @Override
    @PreAuthorize("hasRole('ROLE_SUPERUSER')")
    public User addUser(String username, String password, String permission, String readonly) {
        if (validateNewUsername(username)) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            permission = "ROLE_" + permission.toUpperCase();
            newUser.setPermission(permission);
            newUser.setReadonly(readonly);
            userRepositoryI.save(newUser);
            return newUser;
        } else {
            return null;
        }
    }


    private boolean validateNewUsername(String username) {
        User user = userRepositoryI.findUserByUsername(username);
        return user == null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryI.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        } else {
            userRepositoryI.save(user);
            return new UserPrincipal(user);
        }

    }
}
