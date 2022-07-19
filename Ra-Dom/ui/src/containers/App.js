import HeaderContainer from './Header/HeaderContainer';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';
import {useState} from "react";
import {AuthUserContext, initialAuthUserObj} from "../context/AuthUserContext";
import {saveToSessionStorage, StorageKey} from "../utils/sessionStorage";
import "../i18n"

function App() {
    const [authUser, setAuthUser] = useState(initialAuthUserObj)

    const authContextValue = {
        authUser,
        putAuthUser: (data) => {  // data = { username: '', fullname: '', jwtToken: ''}
            setAuthUser(data)
            saveToSessionStorage(StorageKey.jwt, data.jwtToken)

        },
    }
    return (
        <BrowserRouter>
            <div className="mainApp">
                <AuthUserContext.Provider value={authContextValue}>
                <HeaderContainer />
                <Pages />
                </AuthUserContext.Provider>
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;
