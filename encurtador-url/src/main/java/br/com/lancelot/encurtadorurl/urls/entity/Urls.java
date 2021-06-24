package br.com.lancelot.encurtadorurl.urls.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.PrePersist;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "urls")
public class Urls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_url")
    private Long id;

    @Column(name = "url_original")
    private String urlOriginal;

    @Column(name = "url_encurtada")
    private String urlShorted;

    @Column(name = "criadoEm")
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersistValues() {

        this.createdAt = LocalDateTime.now();
    }
}
