package com.example.demologin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    @Length(min = 5, message = "O campo nome de usuário deve conter no minimo 5 caracteres")
    @NotEmpty(message = "Por favor, preencha o campo nome de usuário")
    private String userName;
    @Column(name = "email")
    @Email(message = "Por favor insira um email valido")
    @NotEmpty(message = "Campo email obrigatório")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "Sua senha está muito curta, por favor insira uma com no minimo 5 caracteres")
    @NotEmpty(message = "Campo senha obritário")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "Insira seu nome")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "Insira seu sobrenome")
    private String lastName;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "role_id")
    Role role;
}