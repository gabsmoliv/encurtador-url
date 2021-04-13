package br.com.lancelot.encurtadorurl.service.abstracts;

import br.com.lancelot.encurtadorurl.model.Usuario;

/**
 * @author gabriel on 10/04/2021
 */

public interface UsuarioService {

    default Usuario salvarUsuario(Usuario usuario) {

        return null;
    }

}
