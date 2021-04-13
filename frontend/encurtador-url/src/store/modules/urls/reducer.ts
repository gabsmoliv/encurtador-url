import { Reducer } from 'redux';
import { Urls, UrlsTypes } from './types';

let urls = localStorage.getItem('urls');
const initialState = urls ? { empty: true, urls } : {};

export function loader(state = initialState, action: any) {

    switch(action.type){
        case UrlsTypes.LOAD_URL:
            return {
              empty: false,
              urls: action.urls
            };
          case UrlsTypes.FAILURE_URL:
            return {};
          default:
            return state
    }
}

export default loader;