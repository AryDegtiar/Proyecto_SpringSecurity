package com.sistemasactivos.user.controller;

import com.sistemasactivos.user.model.User;
import com.sistemasactivos.user.service.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/user")
public class UserController extends BaseControllerImpl<User, UserServiceImpl> {

}