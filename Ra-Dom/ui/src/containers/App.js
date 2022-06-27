import HeaderContainer from './Header/HeaderContainer';
import {
    Routes,
    Route} from "react-router-dom";
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter } from 'react-router-dom';
import HomePage from "./Pages/HomePage";
import ProductsPage from "./Pages/ProductsPage";
import NewProductPage from './Pages/NewProductPage';


function App() {
    return (
        <BrowserRouter>
            <div className='mainApp'>
                <HeaderContainer/>
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/products" element={<ProductsPage />} />
                    <Route path='/product/create' element={ <NewProductPage /> } />
                </Routes>
                <FooterContainer/>
            </div>
    </BrowserRouter>
    );
}

export default App;
