import { configureStore } from '@reduxjs/toolkit';
import cartReducer from './Cart/cartSlice';
import { loadFromLocalStorage, StorageKey } from '../utils/localStorage';
import { createCartChangesSubscription } from '../utils/CartLocalStore';
import userReducer from './User/userReducer';

const preloadedState = () => ({
    cart: loadFromLocalStorage(StorageKey.cart) || undefined,
});

const constructStore = () => {
    const store = configureStore({
        reducer: {
            cart: cartReducer,
            user: userReducer,
        },
        preloadedState: preloadedState(),
    });

    subscribeCart(store);

    return store;
};

const subscribeCart = (store) => {
    store.subscribe(createCartChangesSubscription(store));
};

const store = constructStore();

export default store;
