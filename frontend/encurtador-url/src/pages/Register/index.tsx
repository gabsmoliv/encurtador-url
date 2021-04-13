import React, { useEffect, useRef } from 'react';
import { FormHandles, SubmitHandler } from '@unform/core';
import { Form } from '@unform/web';
import { useHistory } from 'react-router-dom';

import { successRegister, errorRegister} from '../../util/notifications';
import { userActions } from '../../store/modules/users/actions';
import { User } from '../../store/modules/users/types';
import PageBody from '../../components/PageBody';
import FormBody from '../../components/FormBody';
import SaveForm from '../../components/SaveForm';
import Input from '../../components/Input';

function Register() {

    const spaces = {};
    const history = useHistory();
    const formRef = useRef<FormHandles>(null);

    const submitRegister: SubmitHandler<User> = async (data , { reset })=> {

        const userRequest: any= {
            nome: data.nome,
            sobrenome: data.sobrenome,
            email: data.email,
            telefone: data.telefone,
            usuario: data.usuario,
            senha: data.senha,
        }
    
        const userRegisterResponse = await userActions.register(userRequest);
            
        if(userRegisterResponse){
            reset();
            successRegister();
            history.push('/login');
        }else{
            errorRegister();
        }

    }

    return (
        <PageBody
            title="Registro de Usuario"
            isForm={true}
            link="/register"
        >
            <FormBody title="">
                <Form onSubmit={submitRegister} ref={formRef} initialData={ spaces } >
                    <Input
                        name="nome"
                        label="Nome"
                        required={true}
                    />

                    <Input
                        name="sobrenome"
                        label="Sobrenome"
                        required={true}
                    />

                    <Input
                        name="email"
                        label="Email"
                        type="email"
                        required={true}
                    />

                    <Input
                        name="telefone"
                        label="Telefone"
                        type="text"
                        id="telefone"
                        required={true}
                    />
                    
                    <Input
                        name="usuario"
                        label="Usuario"
                        minLength={3}
                        maxLength={15}
                        required={true}
                    />

                    <Input
                        name="senha"
                        label="Senha"
                        type="password"
                        minLength={3}
                        maxLength={20}
                        required={true}
                    />

                    <SaveForm title="Cadastrar"></SaveForm>
                </Form>
            </FormBody>
        </PageBody>        
    );
}

export default Register;
