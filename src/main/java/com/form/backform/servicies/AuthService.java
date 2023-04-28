package com.form.backform.servicies;

import com.form.backform.pojo.LoginReq;
import com.form.backform.responses.RespuestaLogin;
import reactor.core.publisher.Mono;

public interface AuthService {
  Mono<RespuestaLogin> login(LoginReq loginReq);
}
