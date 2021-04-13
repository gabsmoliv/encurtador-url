
import { User } from './types';

export const userService  = {
    login, 
    logout,
    register
}

function login(username: string, password: string) {

    const requestOpts = {
        method: 'POST',
        headers: { 
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ "usuario": username , "senha": password})
    }

    return fetch(`http://localhost:8080/login`, requestOpts)
            .then(handleResponse)
            .then(userResponse => {
                localStorage.setItem('user', JSON.stringify(userResponse));

                return userResponse;
            })
}


function logout() {
    localStorage.clear();
}

function register(userData: User){

    const requestOpts = {
        method: 'POST',
        header: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ "nome": userData.nome, "sobrenome": userData.sobrenome, "telefone": userData.telefone, "email": userData.email, 
            "usuario": userData.usuario, "senha": userData.nome  })
    }
    
    return fetch(`http://localhost:8080/usuarios`, requestOpts)
            .then(handleResponse)
            .then(res => res)

}

function handleResponse(response: any) {

    return response.text().then((text: string) => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
            if (response.status === 401) {
                logout();
                window.location.reload(true);
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    }); 
}
    