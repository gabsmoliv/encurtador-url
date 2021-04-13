import React from 'react';
//import { useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';

//import { User } from '../../store/modules/users/types';
//import { Space } from '../../store/modules/spaces/types';
//import { Event } from '../../store/modules/events/types';
//import { deleteUser, showUser } from '../../store/modules/users/actions';
//import { deleteSpace, showSpace } from '../../store/modules/spaces/actions';
//import { deleteEvent, showEvent } from '../../store/modules/events/actions';

import addIcon from '../../assets/images/icons/add-white.svg';
import deleteIcon from '../../assets/images/icons/delete-white.svg';
import editIcon from '../../assets/images/icons/edit-white.svg';

import api from '../../services/api';


import './style.css';

interface listUrlPropos{
    key: number;
    urlOriginal: string;
    urlEncurtado: string;
    dataCriacao: string | Date | any;
}


const ListItem: React.FC<listUrlPropos> = ({
        key, urlEncurtado, urlOriginal, dataCriacao
    }) => {


    return (
        <main className="list-item">
            { 
                <div className="avatar">
                    <img src="#" alt=""/>
                </div> 
            }
            <article className="content">
                <header>
                    <strong> URL </strong>
                    <span> { key } </span>
                    <br/>              
                </header>
                <div className="body-content">
                    <strong> Url Original: </strong>
                    <span> { urlOriginal } </span>
                    <br/>
                    <strong> Url Encurtada: </strong>
                    <span> { urlEncurtado  } </span>
                    <br/>
                    <strong> Data Criação: </strong>
                    <span> { dataCriacao } </span>
                </div>
            </article>           
        </main>
    )
}

export default ListItem;


/*

 <div className="options">
                {!isBook && (
                    <>
                        <Link to={editLink}>
                            <img src={editIcon} alt="Editar item" onClick={editItem}/>
                        </Link>      
                        
                        <Link to={deleteLink}>
                            <img src={deleteIcon} alt="Deletar item" onClick={deleteItem}/>
                        </Link>
                    </>
                )}

                { reserveLink && (
                    <Link to={reserveLink} id="reserve-link" onClick={reserveItem}>
                        <img src={addIcon} alt="Nova reserva" />
                        Reservar 
                    </Link>    
                )}
            </div>*/


    //const dispatch = useDispatch();

    /*function editItem(){

        if(user){
            //dispatch(showUser(user))
        }

        if(space){
           //dispatch(showSpace(space))
        }

        if(event){
            //dispatch(showEvent(event))
        }

        return console.log('Edit Link ')
    }*/

    /*function deleteItem(){
        const confirmDelete = window.confirm('Você deseja realmente excluir esse registro?')

        if(confirmDelete){
            if(user){
                //api.delete(`auth/delete/${user.id}`);
                //dispatch(deleteUser(user.id))
                // dispatch(loadUsersRequest())
            }
            if(space){
                //api.delete(`espacos/${space.id}`);
                //dispatch(deleteSpace(space.id))
                // dispatch(loadUsersRequest())
            }
            if(event){
                ///api.delete(`eventos/${event.id}`);
                ///dispatch(deleteEvent(event.id))
                // dispatch(loadUsersRequest())
            }
        }
        return console.log('Delete Link')
    }*/

    /*function reserveItem(){
        console.log('RESERVE LINK')
    }*/