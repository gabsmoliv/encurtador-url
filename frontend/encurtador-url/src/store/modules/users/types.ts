export enum UsersTypes {

    LOGIN_REQUEST = 'USER_LOGIN_REQUEST',
    LOGIN_SUCCESS = 'USER_LOGIN_SUCCESS',
    LOGIN_FAILURE = 'USER_LOGIN_FAILURE',
 
    LOGOUT = 'USER_LOGOUT',

    REGISTER_REQUEST = 'USER_REGISTER_REQUEST',
    REGISTER_SUCCESS = 'USER_REGISTER_SUCCESS',
    REGISTER_FAILURE = 'USER_REGISTER_FAILURE'  
  }
  
  export interface User{
    id: number;
    nome: string,
    sobrenome: string;
    email: string;
    telefone: string;
    usuario: string;
    senha: string
    dataAlteracao: string
  }
  
  export interface UsersState {
    readonly data: User[];
    readonly isEdit: boolean;
    readonly formData: User | undefined;
    readonly loading: boolean;
    readonly error: boolean;
  }