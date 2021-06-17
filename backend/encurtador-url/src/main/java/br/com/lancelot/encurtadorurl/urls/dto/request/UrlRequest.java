package br.com.lancelot.encurtadorurl.urls.dto.request;

import lombok.Data;

/**
 * @author gabriel on 10/04/2021
 */

@Data
public class UrlRequest {

    private Long id;

    private String urlOriginal;

    private String urlShorted;

}
