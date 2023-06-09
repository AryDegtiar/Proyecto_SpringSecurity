package com.sistemasactivos.user.service;

import com.sistemasactivos.user.model.User;
import com.sistemasactivos.user.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer>{
    public UserServiceImpl(BaseRepository<User, Integer> baseRepository) {
        super(baseRepository);
    }
}
