package com.invites.controller;

import com.invites.model.entity.User;
import com.invites.model.records.UserRecord;
import com.invites.model.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroUsuario(@RequestBody @Valid UserRecord userRecord){
        return userService.save(new User(userRecord));
    }

    @PostMapping("/atualizar/{id}")
    public void atualizaUsuario(@RequestBody @Valid UserRecord userRecord, @PathVariable Long id){
         userService.update(new User(userRecord), id);
    }

    @PostMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping
    public Page<User> findUsuarios(Pageable pageable){
        return userService.findAll(pageable);
    }

}
