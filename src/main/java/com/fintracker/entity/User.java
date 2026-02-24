package com.fintracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotBlank
    private String fullName;
@NotBlank
    @Column(unique = true, nullable = false)
    private String email;
@NotBlank

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // One user → many transactions
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactions;
}
