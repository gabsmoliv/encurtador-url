package br.com.lancelot.encurtadorurl.controller;

import br.com.lancelot.encurtadorurl.model.request.LoginRequest;
import br.com.lancelot.encurtadorurl.model.response.LoginResponse;
import br.com.lancelot.encurtadorurl.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

/**
 * @author gabriel on 08/04/2021
 */

@RestController
@RequestMapping(path = {"/login"})
public class LoginController {

    private final LoginServiceImpl loginService;

    LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LinkedHashMap<String, Object>> logar(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(this.loginService.logar(loginRequest.getUsuario(), loginRequest.getSenha()));
    }

}
