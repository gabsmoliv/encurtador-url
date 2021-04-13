package br.com.lancelot.encurtadorurl.model.response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * @author gabriel on 08/04/2021
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    private String email;

    private String telefone;

    @NotNull
    private String usuario;

    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

}

