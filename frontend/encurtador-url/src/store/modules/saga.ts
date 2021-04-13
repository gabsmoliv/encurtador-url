/*import { all, takeLatest} from 'redux-saga/effects'

import { UsersTypes } from './users/types';
import { loadUsersSaga } from './users/saga';
//import { UrlsTypes } from './urls/types';
//import { loadUrlSaga } from './urls/saga';

export default function* saga(){
  
  return yield all([
    takeLatest(UsersTypes.LOAD_USERS_REQUEST, loadUsersSaga ),
    
  ])
 
} */


export default function* saga() {
  return null;
}

//takeLatest(UrlsTypes.LOAD_URL, loadUrlSaga)

/*interface User {id; name; address}
interface Order {id; date; items; supplierId}
interface Supplier {id; name; phone}
declare function getUser(id: number): Promise<User>;
declare function getOrders(user: User): Promise<Order[]>;
declare function getSupplier(id: number): Promise<Supplier>;

function* foo() {
    let user = yield getUser(42); // user is of type 'any'
    let user2 = <User> user;
    return user2; // This return type is not preserved
}

function* bar() { // ERROR: No best common type exists among yield expressions
    let user = yield getUser(42);       // user has type 'any'
    let orders = yield getOrders(user); // orders has type 'any'

    let orders2 = <Order[]> orders;
    let suppliers = yield orders2.map(o => getSupplier(o.supplierId)); // suppliers has type 'any'

    let suppliers2 = <Supplier[]> suppliers;
    return suppliers2; // This return type is not preserved
}*/