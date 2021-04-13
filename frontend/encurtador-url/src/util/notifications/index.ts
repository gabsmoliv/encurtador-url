import 'react-toastify/dist/ReactToastify.css';
import { toast } from 'react-toastify';

export const errorLogin = () => toast.error('Falha na autenticação, verifique seus dados');
export const successRegister = () => toast.success('Cadastro efetuado com sucesso!');
export const errorRegister = () => toast.error('Falha no cadastro, verifique os campos');
export const successUpdate = () => toast.success('Cadastro atualizado com sucesso!');

