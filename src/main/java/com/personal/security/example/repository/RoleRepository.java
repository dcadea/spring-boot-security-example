package com.personal.security.example.repository;

import com.personal.security.example.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.role = 'ROLE_USER'")
    Set<Role> getRoleUser();

}
