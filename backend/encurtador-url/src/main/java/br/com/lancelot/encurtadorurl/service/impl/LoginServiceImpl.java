package br.com.lancelot.encurtadorurl.service.impl;

import static br.com.lancelot.encurtadorurl.util.Constantes.*;
import static br.com.lancelot.encurtadorurl.util.Exceptions.checkAndThrow;
import static br.com.lancelot.encurtadorurl.util.CryptSenha.passwordEncoder;

import br.com.lancelot.encurtadorurl.model.response.LoginResponse;
import br.com.lancelot.encurtadorurl.model.Usuario;
import br.com.lancelot.encurtadorurl.repositories.UsuarioRepositorio;
import br.com.lancelot.encurtadorurl.security.JWTAuthUtils;
import br.com.lancelot.encurtadorurl.service.abstracts.LoginService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * @author gabriel on 08/04/2021
 */

@Service
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepositorio  usuarioRepositorio;
    private final JWTAuthUtils authentication;

    private LoginServiceImpl(UsuarioRepositorio usuarioRepositorio, JWTAuthUtils jwtAuthUtils) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.authentication = jwtAuthUtils;
    }

    @Override
    public LinkedHashMap<String, Object> logar(String usuario, String senha) {

        Usuario usuarioRequest = usuarioRepositorio.findByUsuario(usuario);
        checkAndThrow(Objects.isNull(usuarioRequest), USUARIO_BAD_REQUEST);

        boolean checkIsPass = passwordEncoder().matches(senha, usuarioRequest.getSenha());
        checkAndThrow(!checkIsPass, USUARIO_SENHA_INCORRETOS);

        LoginResponse usuarioLoginResponse = LoginResponse.builder()
                .nome(usuarioRequest.getNome())
                .sobrenome(usuarioRequest.getSobrenome())
                .email(usuarioRequest.getEmail())
                .telefone(usuarioRequest.getTelefone())
                .usuario(usuarioRequest.getUsuario())
                .dataAlteracao(usuarioRequest.getDataAlteracao())
                .build();

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        String tokenCreated = authentication.createToken(usuarioLoginResponse.getNome());

        map.put("token", tokenCreated);
        map.put("usuario", usuarioLoginResponse);

        return map;

    }
}

