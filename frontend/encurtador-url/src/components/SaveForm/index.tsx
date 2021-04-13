import React, { ButtonHTMLAttributes } from 'react';

import  './style.css';

interface SaveProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  title: string;
}

const SaveForm: React.FC<SaveProps>  = ({ title, ...rest }) =>{
  return (
                    
    <div className="button-container">
      <button type="submit" {...rest}>{ title }</button>
    </div>

  );
}

export default SaveForm;