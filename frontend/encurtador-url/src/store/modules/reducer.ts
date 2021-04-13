import { combineReducers } from 'redux';

import userReducer from './users/reducer';
import urlReducer from './urls/reducer';

const rootReducer = combineReducers({
  user: userReducer,
  urls: urlReducer
})

export default rootReducer

