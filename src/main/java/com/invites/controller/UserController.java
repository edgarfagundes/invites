package com.invites.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import com.invites.model.entity.User;
import com.invites.model.records.UserRecord;
import com.invites.model.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> atualizaUsuario(@RequestBody @Valid UserRecord userRecord, @PathVariable Long id){
        return userService.update(new User(userRecord), id);
    }

    @PostMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){}

}
