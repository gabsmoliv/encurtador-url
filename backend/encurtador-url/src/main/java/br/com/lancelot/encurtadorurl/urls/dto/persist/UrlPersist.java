package br.com.lancelot.encurtadorurl.urls.dto.persist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlPersist {

    private String urlOriginal;

    private String urlShorted;

}
