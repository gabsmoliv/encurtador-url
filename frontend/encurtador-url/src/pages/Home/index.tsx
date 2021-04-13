import React, { ReactPropTypes, useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Form } from '@unform/web';
import * as Yup from 'yup';
import { FormHandles, SubmitHandler } from '@unform/core';
import { store } from '../../store/index';

import Input from '../../components/Input';
import SaveForm from '../../components/SaveForm';
import ItensList from '../../components/List';

import { urlsActions } from '../../store/modules/urls/actions';
import { urlActions } from '../../store/modules/url/actions';

import  './style.css';
import { ApplicationState } from '../../store';
import { Urls } from '../../store/modules/urls/types';

interface urlData{
    url: string;
}

interface urls{
    id: number
    urlOriginal: string
    urlEncurtada: string
    dataCriacao: string
}




class Home extends React.Component<{}, { urlEncurtada: string, urlsUsuario: any }> {


    constructor(props: any) {
        super(props);
        const vazio: urls = {id: 1, urlOriginal: '', urlEncurtada: '', dataCriacao: ''}
        this.state = {
            urlEncurtada: '',
            urlsUsuario: JSON.parse(localStorage.getItem('urls') || '{}')
        }
    
    }

    atualizrUrl = async (data: urlData) => {


        try {

            //formRef.current?.setErrors({})
            
            const schemaDoc = Yup.object().shape({        
                url: Yup.string().required('Por favor, insira uma url.'),
            });

            await schemaDoc.validate(data , {
                abortEarly: false,
            });

            const result: any = await urlActions.shortUrl(1, data.url);
            const urlResult: string = result.urlEncurtada;
        
            this.setState({ urlEncurtada: urlResult})
            
            
        } catch(err) {
            if(err instanceof Yup.ValidationError) {
                err.inner.forEach( error => {
                    //this.formRef.current?.setFieldError("" + error.path, error.message)
                })
            }
        }
    }
    
    render() {

        //const formRef = useRef<FormHandles>(null);
        const { urlEncurtada } = this.state

        return (

            <div className="container">
                <div id="upper-container" className="upper-container">
                    <h2>Icone da Aplicação</h2>
                    <div id="url-container" className="url-container">    
                        <Form  id="url-form" className="url-form" onSubmit={this.atualizrUrl} ref={null}>
                            <Input id="url-input" className="url-input" name="url" label="Digite a url:"></Input>       
                            <SaveForm id="submit-btn" className="submit-btn" title="Go!"/>    
                        </Form>
                        <h2>{ urlEncurtada }</h2>
                    </div>
                </div>
        
                <div id="downer-container" className="downer-container">
                    <h2>Lista de Links Gerados:</h2>
                    <div className="list-section" id="list-section">
                        {  this.state.urlsUsuario.map((url: Urls) => {
                            return(
                                <ItensList 
                                    key={url.id+1}
                                    urlOriginal={url.urlOriginal}
                                    urlEncurtado={"http://localhost:8080/" + url.urlEncurtada}
                                    dataCriacao={url.dataOperacao}
                                ></ItensList>
                            )}
                        )}
                    </div>
                    
                </div>

            </div>        
        );  
    }
}

export default Home;

