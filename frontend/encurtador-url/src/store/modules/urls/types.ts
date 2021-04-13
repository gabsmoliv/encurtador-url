export enum UrlsTypes {
    LOAD_URL = 'URL/LOAD_URL',
    FAILURE_URL = 'URL/LOAD_FAILURE'
}

export interface Urls{
    id: number;
    urlOriginal: string;
    urlEncurtada: string;
    idUsuario: number;
    dataOperacao: string;
}

export interface UrlsState{
    readonly data: Urls[];
    readonly loading: boolean;
    readonly formData: Urls | undefined;
    readonly error: boolean;
}