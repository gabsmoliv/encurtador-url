import React from 'react';

import { Link } from 'react-router-dom';

import addIcon from '../../assets/images/icons/add-white.svg';
import backIcon from '../../assets/images/icons/return.svg';

import './style.css'

interface PageBodyProps {
    title: string;
    link?: string;
    isForm?: boolean;
    reserveLink?: string;
    isReserve?: boolean;
    reservationTitle?: string;
    isBook?: boolean;
    myReservationsLink?: string; 
}

const  PageBody: React.FC<PageBodyProps> = (
    { title, children }) => {
    return (
        <div className="container">
            <article className="page-body">
               <header className="top-header">
                    <div className="top-bar-container">
                        <h1>{title}</h1>
                    </div>
               </header>
                {children}
            </article>
 
        </div>
    )
}

export default PageBody;