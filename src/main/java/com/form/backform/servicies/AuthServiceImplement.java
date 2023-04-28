package com.form.backform.servicies;

import com.form.backform.pojo.LoginReq;
import com.form.backform.responses.RespuestaLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImplement implements AuthService{


    @Override
    public Mono<RespuestaLogin> login(LoginReq loginReq) {
        Mono<String> password = Mono.just("admin123");

        return  password.map(
             usuario1 -> {
                 if (usuario1.equals(loginReq.getContrasenia())) {

                     return new RespuestaLogin(true);
                 }

                 return new RespuestaLogin(false);

             }
        );

    }
}
