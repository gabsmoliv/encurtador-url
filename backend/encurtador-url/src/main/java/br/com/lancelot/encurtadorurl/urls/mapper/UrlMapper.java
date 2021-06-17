package br.com.lancelot.encurtadorurl.urls.mapper;

import br.com.lancelot.encurtadorurl.urls.dto.response.UrlResponse;
import br.com.lancelot.encurtadorurl.urls.entity.Urls;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UrlMapper {

    UrlMapper INSTANCE = Mappers.getMapper( UrlMapper.class );

    UrlResponse urlToUrlResponse(Urls urls);
}
