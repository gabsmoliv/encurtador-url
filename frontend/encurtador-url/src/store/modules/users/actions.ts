import { action } from 'typesafe-actions';
import { userService } from './service';
import { User, UsersTypes } from './types';

export const userActions = {
    login,
    logout,
    register
};

function login(username: string, password: string) {
    return userService.login(username, password).then(
        (user: User) => {
            action(UsersTypes.LOGIN_SUCCESS, user)
            return 200;
        },
        (error: string) => {
            action(UsersTypes.LOGIN_FAILURE, error)
            return 500;
        }
    )
}

function logout() {
    userService.logout();
    return { type: UsersTypes.LOGOUT };
}

function register(user: User){
    return userService.register(user)
        .then(
            user => {
                return 200;
            }, 
            error => {
                return 500;
            }
        )
}

/*function register(user) {
    return dispatch => {
        dispatch(request(user));

        userService.register(user)
            .then(
                user => { 
                    dispatch(success());
                    history.push('/login');
                    dispatch(alertActions.success('Registration successful'));
                },
                error => {
                    dispatch(failure(error.toString()));
                    dispatch(alertActions.error(error.toString()));
                }
            );
    };

    function request(user) { return { type: userConstants.REGISTER_REQUEST, user } }
    function success(user) { return { type: userConstants.REGISTER_SUCCESS, user } }
    function failure(error) { return { type: userConstants.REGISTER_FAILURE, error } }
}*/


/*export const addUser = (data: User) => action(UsersTypes.ADD_USER,  { data });
export const loadUsersRequest = () => action( UsersTypes.LOAD_USERS_REQUEST);
export const loadUsers = (data: User[]) => action( UsersTypes.LOAD_USERS, { data } );
export const showUser = ( data: User) => action(UsersTypes.SHOW_USER, { data });
export const updateUser = ( data: User ) => action(UsersTypes.UPDATE_USER, { data } );
export const deleteUser = (id: number) => action(UsersTypes.DELETE_USER, { id });*/

/*import { userConstants } from '../_constants';
import { userService } from '../_services';
import { alertActions } from './';
import { history } from '../_helpers';



function login(username, password) {
    return dispatch => {
        dispatch(request({ username }));

        userService.login(username, password)
            .then(
                user => { 
                    dispatch(success(user));
                    history.push('/');
                },
                error => {
                    dispatch(failure(error.toString()));
                    dispatch(alertActions.error(error.toString()));
                }
            );
    };

    function request(user) { return { type: userConstants.LOGIN_REQUEST, user } }
    function success(user) { return { type: userConstants.LOGIN_SUCCESS, user } }
    function failure(error) { return { type: userConstants.LOGIN_FAILURE, error } }
}*/
