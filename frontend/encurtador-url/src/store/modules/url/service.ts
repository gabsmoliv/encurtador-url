import { authHeader } from '../../../services/auth';

export const service = {
    shorter
}

function shorter(idUsuario: number, url: String) {

    const requestOpts = {
        method: 'POST',
        headers: { 'Authorization' : authHeader() }
    }
    
    return fetch(`http://localhost:8080/encurtar?url=${url}&id_usuario=${idUsuario}`, requestOpts)
    .then(handler)
    .then(urlResponse => {
       
        return urlResponse;
    })
}

function handler(response: Response) {
    
    return response.text().then((text: string) => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
           
            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    }); 
}   