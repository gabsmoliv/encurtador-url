import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';

import Navbar from './components/Navbar';
import Routes from './routes';

import './assets/styles/global.css'

function App() {
    return (
        <BrowserRouter>
            <Navbar/>
            <Routes/>
            <ToastContainer autoClose={3000} position="top-center"/>
        </BrowserRouter>
     );
}
 
export default App;