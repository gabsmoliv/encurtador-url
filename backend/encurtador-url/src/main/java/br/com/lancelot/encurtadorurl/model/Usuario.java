package br.com.lancelot.encurtadorurl.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author gabriel on 08/04/2021
 */

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    private String email;

    private String telefone;

    @NotNull
    private String usuario;

    @NotNull
    private String senha;

    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

}
