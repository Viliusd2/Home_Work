import HeaderContainer from './Header/index';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';
import '../i18n';
import '../validation';
import { Provider } from 'react-redux';
import store from '../redux/store';

function App() {
    return (
        <Provider store={store}>
            <BrowserRouter>

                <div className="mainApp">
                    <HeaderContainer />
                    <Pages />
                </div>
                <FooterContainer className="footer"/>

            </BrowserRouter>
        </Provider>
    );
}

export default App;
