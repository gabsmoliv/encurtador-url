import { Reducer } from 'redux';
import { UrlTypes } from './types';

let url = localStorage.getItem('url');
const initialState = url ? url : {};

export function loader(state = initialState, action: any) {

    switch(action.type){
        case UrlTypes.LOAD_URL:
            return {
              empty: false,
              urls: action.urls
            };
          default:
            return state
    }
}

export default loader;