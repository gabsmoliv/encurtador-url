import { service } from './service';
import { action } from 'typesafe-actions';
import { UrlTypes } from './types';

export const urlActions = {
    shortUrl
}

function shortUrl(idUsuario: number, url: string) {
    return service.shorter(idUsuario, url).then(
        response => {
            localStorage.setItem('url', response)
            action(UrlTypes.LOAD_URL, response)
            return response;
        },
        error => {
            return error;
        }
    )
}

