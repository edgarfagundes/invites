package com.invites.model.entity;


import com.invites.model.records.UserRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends IdGenerator{

    @NotNull
    private String name;

    @NotNull
    private String cpf;

    @NotNull
    private Boolean confirmation;

    public User(UserRecord user){
        this.name = user.name();
        this.cpf = user.cpf();
        this.confirmation = user.confirmation();
    }


}
