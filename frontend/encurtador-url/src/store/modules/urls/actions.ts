import { action } from 'typesafe-actions';
import { Urls, UrlsTypes } from './types';
import { urlService } from './service';

export const urlsActions = {
    loadUrls
}

function loadUrls(username: string){

    return urlService.getAllByUser(username).then(
        url => {
            action(UrlsTypes.LOAD_URL, url)
            return 200;
        },
        error => {
            action(UrlsTypes.FAILURE_URL, error)
            return 500;
        }
    )
}
