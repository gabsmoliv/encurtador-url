package br.com.lancelot.encurtadorurl.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author gabriel on 08/04/2021
 */


@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "urls")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Urls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_url")
    private Long id;

    @Column(name = "url_original")
    private String urlOriginal;

    @Column(name = "url_encurtada")
    private String urlEncurtada;

    @Column(name = "data_operacao")
    private LocalDateTime dataOperacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
