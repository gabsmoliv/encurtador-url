package br.com.lancelot.encurtadorurl.urls.repository;

import br.com.lancelot.encurtadorurl.urls.entity.Urls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Urls, Long> {

    Urls findByUrlShorted(String urlShorted);

}
