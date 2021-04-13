import { authHeader } from '../../../services/auth';

export const urlService = {
    getAllByUser
}

function getAllByUser(username: string) {

    const requestOpts = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': authHeader()
        },
        body: JSON.stringify({ usuario: username })
    }
    
    return fetch(`http://localhost:8080/urls`, requestOpts)
    .then(handler)
    .then(urlResponse => {
        localStorage.setItem('urls', JSON.stringify(urlResponse))

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






