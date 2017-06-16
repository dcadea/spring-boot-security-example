package com.personal.security.example.model;

import com.personal.security.example.enums.RoleType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_role")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @NonNull
    @Enumerated(STRING)
    @Column(nullable = false, length = 15)
    private RoleType role;

    @NonNull
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String toString() {
        return role.name();
    }
}
