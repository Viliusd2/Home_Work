import { Route, Routes } from 'react-router-dom';
import HomePage from './Home/HomePage';
import ProductsPage from './Product/ProductsPage';
import NewProductCreationPage from './Product/NewProductCreationPage';
import CartPage from './Cart/CartPage';
import LoginPage from './Login/LoginPage';

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/product/create" element={<NewProductCreationPage />} />
        <Route path="/cart" element={<CartPage />} />
        <Route path="/login" element={<LoginPage />} />
    </Routes>
);
