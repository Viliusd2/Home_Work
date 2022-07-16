import { Route, Routes } from 'react-router-dom';
import HomePage from './Home/HomePage';
import ProductsPage from './Product/ProductsPage';
import Product from './Product/Product';
import CartPage from "./Cart/CartPage";
import Login from "./Login/Login";

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/product/:productId" element={<ProductsPage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/product/create" element={<Product />} />
        <Route path="/cart" element={<CartPage />} />
        <Route path="/login" element={<Login />} />

    </Routes>
);
