package org.example.question_1_2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_EMAIL", columnNames = "email"),
        @UniqueConstraint(name = "UNIQUE_UserName", columnNames = "userName"),
})
public class UserEntity  extends BaseEntity{

    @Column(name = "email" )
    @Email
    @NotBlank
    private  String email;

    @NotBlank
    @Column(name = "userName" )
    private String userName;

    @NotBlank
    @Column(name = "password" )
    private  String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

}
