import { useRef } from 'react';
import { FormHandles, SubmitHandler } from '@unform/core';
import { useHistory } from 'react-router-dom';
import { Form } from '@unform/web';
import * as Yup from 'yup';

import api from '../../services/api';
import Input from '../../components/Input';
import SaveForm from '../../components/SaveForm';
import { Link } from 'react-router-dom';
import { errorLogin } from '../../util/notifications';
import { userActions } from '../../store/modules/users/actions';
import { urlsActions } from '../../store/modules/urls/actions';

import './style.css';
import { string } from 'yup/lib/locale';


interface LoginData{
    username: string;
    password: string;
}


function Login() {

    const history = useHistory();
    const formRef = useRef<FormHandles>(null);
   
    const loginRequest: SubmitHandler<LoginData> = async data => {

        try {
            formRef.current?.setErrors({})

            const schemaDoc = Yup.object().shape({        
                username: Yup.string().required('Por favor, digite o nome de usuário'),
                password: Yup.string().required('Por favor, digite a senha'),
            });

            await schemaDoc.validate(data , {
                abortEarly: false,
            });

            const userResponse = await userActions.login(data.username, data.password);

            if(userResponse == 200) {
                urlsActions.loadUrls(data.username)
                history.push('/');
            } else {
                errorLogin();
            }

        } catch(err) {
            if(err instanceof Yup.ValidationError) {
                err.inner.forEach( error => {
                    formRef.current?.setFieldError("" + error.path, error.message)
                })
            }
        }
    }

    return (
        <div className="container">
            <article className="login-body">
                <header className="login-header">
                    <div className="login-container">
                        <fieldset>
                            <legend><h2>Login</h2></legend>
                        </fieldset>
                        <Form onSubmit={loginRequest} ref={formRef}>
                            <Input name="username" label="Usuario"></Input>
                            <Input name="password" label="Senha" type="password"></Input>
                            <SaveForm title="Logar"/>
                            
                        </Form>
                    </div>
                        <Link to="/register">
                            <h2 className="register">Cadastre-se</h2>
                        </Link>
                </header>
            </article>
            <div>
                
            </div>
        </div>
    ); 
}

export default Login;


            /*await api.post(`login`,
            {}, {
                headers: {
                    'login': data.username,
                    'senha': data.password  
                }
            }).then(response => {
                
                if(response.status === 200) {
                    history.push('/');
                } 
                
                console.log(response.status)
            }).catch(() => {
                errorLogin();
            });*/

