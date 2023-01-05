package com.invites.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "id_generator")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class IdGenerator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
}
