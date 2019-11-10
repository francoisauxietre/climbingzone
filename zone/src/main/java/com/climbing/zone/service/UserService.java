package com.climbing.zone.service;

import com.climbing.zone.repository.UserRepository;
import com.climbing.zone.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> findAll(){
        return UserDto.toDTO(userRepository.findAll());
    }


}
