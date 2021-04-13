import React from 'react';
import { Link } from 'react-router-dom';
import { userActions } from '../../store/modules/users/actions';
import { isAuthenticated } from '../../services/auth';

import './style.css';
import iconeLogout from '../../assets/images/icons/logout.svg';

class Navbar extends React.Component<{}, { isAuth: boolean, usuario: any}> {

    constructor(props: any) {
        super(props);
        
        this.state = {
            isAuth: isAuthenticated(),
            usuario: JSON.parse(localStorage.getItem('user') || '{}')
        }
    
    }

    logOut = () => {
        this.setState({ isAuth: false })
        userActions.logout();
    }

   
     render () {
        return(
            <header className="page-header">
            <nav className="navbar">                
                <ul className="menu">
                    <li className="app-name">
                    <Link to="/">Encurtador Url</Link>  
                    </li>
                </ul>
                
            </nav>
            <ul className="secondary-menu">
                    <li className="user-name">
                        { this.state.isAuth ? <span> Olá, { this.state.usuario.usuario.nome }</span> : <span></span>}
                        { this.state.isAuth ?  <Link to="#">
                            <img src={iconeLogout} alt="logout" onClick={this.logOut}/>
                        </Link>: "" }
                       
                    </li>
                </ul>
         
        </header>
        )
    }

}

/*function Navbar() {

    return (
        <header className="page-header">
            <nav className="navbar">                
                <ul className="menu">
                    <li className="app-name">
                    <Link to="/">Encurtador Url</Link>  
                    </li>
                </ul>
                
            </nav>
            <ul className="secondary-menu">
                    <li className="user-name">
                        { verificarAutentitcado() ? <span>Olá, User</span> : <span></span>}
                        <Link to="#">
                            <img src={iconeLogout} alt="logout" onClick={logOut}/>
                        </Link>
                    </li>
                </ul>
            
        </header>
    )
}*/

export default Navbar;

/*
<div className="logout">
                <span>Olá, User</span>
                <Link to="#">
                    <img src={iconeLogout} alt="logout" onClick={logOut}/>
                </Link>
            </div> :
*/


/**
 *   <Link to="#">
                    
                </Link>
 */

/**                   <h2>Encurtador Url</h2>
 *  <li className="app-name">
                        <Link to="/">ENCURTADOR URL</Link>
                    </li>
 */