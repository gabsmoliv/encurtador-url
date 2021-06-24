package br.com.lancelot.encurtadorurl.urls.dto.persist;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class UrlPersist {

    @NotNull
    private String urlOriginal;

}
