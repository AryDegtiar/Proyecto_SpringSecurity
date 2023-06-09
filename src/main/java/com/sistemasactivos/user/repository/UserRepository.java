package com.sistemasactivos.user.repository;

import com.sistemasactivos.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Integer>{
    Optional<User> findOneByEmail(String email);
}
