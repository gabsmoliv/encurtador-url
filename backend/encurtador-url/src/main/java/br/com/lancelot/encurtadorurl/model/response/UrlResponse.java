package br.com.lancelot.encurtadorurl.model.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


/**
 * @author gabriel on 09/04/2021
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlResponse {

    private Long id;

    private String urlOriginal;

    private String urlEncurtada;

    private String dataOperacao;

}
