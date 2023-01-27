package com.invites.model.services;

import com.invites.model.entity.User;
import com.invites.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> save(User user){
        try {
            if(user.getId() != null) {
                return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
            }else {
                throw new Exception();
            }
        }catch (Exception e){
             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public void update(User user, Long id){
        try {
            if (user.getId().equals(id)) {
                 new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
            }else {
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public void delete(Long id){
        userRepository.deleteById(id);
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
