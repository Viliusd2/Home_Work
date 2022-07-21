import { saveToLocalStorage, StorageKey } from './localStorage';
import throttle from 'lodash/throttle';

let prevCart = [];

export const createCartChangesSubscription = (store) => {
    return throttle(() => {
        console.log('lodash throttle event!');
        const currentCart = store.getState().cart;

        if (prevCart !== currentCart) {
            prevCart = currentCart;
            saveToLocalStorage(StorageKey.cart, currentCart);
        }

        return currentCart;
    }, 3000);
};
