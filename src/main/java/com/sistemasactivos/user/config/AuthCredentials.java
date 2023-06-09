package com.sistemasactivos.user.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthCredentials {
    private String email;
    private String password;
    //@JsonIgnore
    //private String name;
}
