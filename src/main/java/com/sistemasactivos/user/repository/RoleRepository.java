package com.sistemasactivos.user.repository;

import com.sistemasactivos.user.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role, Integer>{
    Optional<Role> findByName(String name);
}
