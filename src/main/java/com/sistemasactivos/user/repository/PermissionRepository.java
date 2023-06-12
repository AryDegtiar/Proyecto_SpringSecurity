package com.sistemasactivos.user.repository;

import com.sistemasactivos.user.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends BaseRepository<Permission, Integer>{
    Optional<Permission> findByName(String name);
}
