package br.com.lancelot.encurtadorurl.repositories;

import br.com.lancelot.encurtadorurl.model.Urls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepositorio extends JpaRepository<Urls, Long> {

    Urls findByUrlEncurtada(String Url_encurtada);

    @Query(value = "SELECT * FROM urls WHERE id_usuario = ?", nativeQuery = true)
    List<Urls> findAllById(Long id);
}
