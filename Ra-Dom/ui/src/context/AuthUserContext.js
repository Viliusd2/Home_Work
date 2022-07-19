import { createContext, useState } from 'react';

const AuthUserContext = createContext(null)

const initialAuthUserObj = {
    username: '',
    fullName: '',
    jwtToken: '',
};

export {
    AuthUserContext,
    initialAuthUserObj,
}
