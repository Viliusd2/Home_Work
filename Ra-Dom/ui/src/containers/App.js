import HeaderContainer from './Header/HeaderContainer';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter } from 'react-router-dom';
import { Routes, Route } from 'react-router-dom';
import HomePage from './Pages/HomePage';
import ProductPage from './Pages/ProductPage';
import NewProductPage from './Pages/NewProductPage';

function App() {
    return (
        <BrowserRouter>
            <div className="mainApp">
                <HeaderContainer />
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route
                        path="/product/:productId"
                        element={<ProductPage />}
                    />
                    <Route
                        path="/products/create"
                        element={<NewProductPage />}
                    />
                </Routes>
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;
