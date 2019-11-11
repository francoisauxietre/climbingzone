package com.climbing.zone.service;

import com.climbing.zone.repository.UserRepository;
import com.climbing.zone.service.dto.UserDto;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    Logger logger;

    @Autowired
    UserRepository userRepository;

    //ok
    public List<UserDto> findAll() {
        return UserDto.toDTO(userRepository.findAll());
    }

    //en cours
    public UserDto findByUsername(String username) {
        UserDto userDto = new UserDto();
        if (userRepository.findByUsername(username) == null) {
            logger.info("erreur cet utilisateur de nom" + username + " n'exite pas");
        } else {
            userDto.toDto(userRepository.findByUsername(username));
        }
        return userDto;
    }
}
