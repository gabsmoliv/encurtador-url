package br.com.lancelot.encurtadorurl.service.impl;

import static br.com.lancelot.encurtadorurl.util.Exceptions.checkAndThrow;
import static br.com.lancelot.encurtadorurl.util.Constantes.USUARIO_VAZIO;
import static br.com.lancelot.encurtadorurl.util.Constantes.USUARIO_CADASTRADO;
import static br.com.lancelot.encurtadorurl.util.Constantes.VAZIO;
import static br.com.lancelot.encurtadorurl.util.CryptSenha.passwordEncoder;

import br.com.lancelot.encurtadorurl.model.Usuario;
import br.com.lancelot.encurtadorurl.repositories.UsuarioRepositorio;
import br.com.lancelot.encurtadorurl.service.abstracts.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author gabriel on 10/04/2021
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    UsuarioServiceImpl(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {

        checkAndThrow(Objects.isNull(usuario), USUARIO_VAZIO);

        Usuario usuarioExiste = usuarioRepositorio.findByUsuario(usuario.getUsuario());
        checkAndThrow(Objects.nonNull(usuarioExiste), USUARIO_CADASTRADO);

        if(VAZIO.equals(usuario.getSenha()) || VAZIO.equals(usuario.getUsuario())){
            return null;
        }

        String senhaCriptograda = passwordEncoder().encode(usuario.getSenha());
        usuario.setSenha(senhaCriptograda);

        return usuarioRepositorio.save(usuario);
    }

}

