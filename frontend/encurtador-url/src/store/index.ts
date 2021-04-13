import { applyMiddleware, createStore, Store } from 'redux';
import thunkMiddleware from 'redux-thunk';
//import { createLogger } from 'redux-logger'; logger do redux

import createSagaMiddleware from 'redux-saga';
import rootReducer from './modules/reducer';

import { UsersState } from './modules/users/types';
import { UrlsState } from './modules/urls/types';

//import saga from './modules/saga';

export interface ApplicationState {
  users: UsersState,
  urls: UrlsState,
}

/* Store<ApplicationState>

const sagaMiddleware = createSagaMiddleware();

const store = createStore(reducer, applyMiddleware(sagaMiddleware)); 

//sagaMiddleware.run(saga)

export default store;*/


//const loggerMiddleware = createLogger();

export const store = createStore(
    rootReducer,
    applyMiddleware(
        thunkMiddleware
    )
);


