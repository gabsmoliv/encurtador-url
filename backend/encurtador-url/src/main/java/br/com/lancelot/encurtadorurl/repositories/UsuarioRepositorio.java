package br.com.lancelot.encurtadorurl.repositories;

import br.com.lancelot.encurtadorurl.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findTopById(Long id);

    Usuario findByUsuario(String usuario);

}
