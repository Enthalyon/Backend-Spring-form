package com.form.backform.controllers;


import com.form.backform.pojo.LoginReq;
import com.form.backform.responses.RespuestaLogin;
import com.form.backform.servicies.AuthServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AuthController {

    @Autowired
    private AuthServiceImplement authServiceImplement;

    @PostMapping ("/login")
    public Mono<ResponseEntity<RespuestaLogin>> login(@RequestBody LoginReq loginReq){

        Mono<RespuestaLogin> logeoExitoso = authServiceImplement.login(loginReq);

        return logeoExitoso.map(reg -> {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");

            return new ResponseEntity<RespuestaLogin>(
                    reg,
                    headers,
                    reg.isSuccessful ? HttpStatus.OK : HttpStatus.UNAUTHORIZED
            );
        });
    }
}
