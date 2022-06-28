import HeaderContainer from './Header/HeaderContainer';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';

function App() {
    return (
        <BrowserRouter>
            <div className="mainApp">
                <HeaderContainer />
                <Pages />
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;
