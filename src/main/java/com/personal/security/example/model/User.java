package com.personal.security.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false, length = 25)
    private String username;

    @NonNull
    @Column(nullable = false, length = 100)
    private String password;

    @NonNull
    @Column(nullable = false)
    private Boolean active;

    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "t_users_roles",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private Set<Role> roles;

}
