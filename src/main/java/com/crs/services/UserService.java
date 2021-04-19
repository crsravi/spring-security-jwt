package com.crs.services;

import com.crs.dto.MyUserPrincipal;
import com.crs.dto.UserDto;
import com.crs.entities.User;
import com.crs.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class  UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public String saveDto(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return save(user).getUsername();
    }

    private User save(User user){
        return userRepository.save(user);
    }

    public List getAllUsers(){
        return userRepository.findAll();

    }

    public User findUser(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

}
