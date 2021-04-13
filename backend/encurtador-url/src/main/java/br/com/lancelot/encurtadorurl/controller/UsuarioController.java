package br.com.lancelot.encurtadorurl.controller;

import static br.com.lancelot.encurtadorurl.util.Constantes.USUARIO_BAD_REQUEST;
import static br.com.lancelot.encurtadorurl.util.Constantes.USUARIO_CRIADO;

import br.com.lancelot.encurtadorurl.model.Usuario;
import br.com.lancelot.encurtadorurl.service.impl.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author gabriel on 10/04/2021
 */

@RestController
@RequestMapping(path = {"/usuarios"})
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Usuario usuarioRequest) {

        Usuario usuarioResponse = usuarioService.salvarUsuario(usuarioRequest);

        if(Objects.isNull(usuarioResponse)) {
            return ResponseEntity.badRequest().body(USUARIO_BAD_REQUEST);
        } else {
            return ResponseEntity.ok().body(USUARIO_CRIADO);
        }
    }

}
