package br.com.lancelot.encurtadorurl.urls.dto.request;

import lombok.Data;
@Data
public class UrlRequest {

    private Long id;

    private String urlOriginal;

    private String urlShorted;

}
