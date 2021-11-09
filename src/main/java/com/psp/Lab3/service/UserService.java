package com.psp.Lab3.service;





import com.psp.Lab3.validators.UserValidator;
import com.psp.Lab3.model.User;
import com.psp.Lab3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    UserValidator userValidator = new UserValidator("$%","LT",5);

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getById(int userId){
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user.get();
    }
    public User add(User user){
        if(user == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        user = userValidator.validate(user);
        return userRepository.save(user);
    }
    public User update(User user){
        if(user == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        user = userValidator.validate(user);
        return userRepository.save(user);
    }
    public void removeById(int userId){
        getById(userId);
        userRepository.deleteById(userId);
    }

}
