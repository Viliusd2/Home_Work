import { Route, Routes } from 'react-router-dom';
import HomePage from './Home/HomePage';
import ProductPage from './Product/ProductPage';
import CreateProduct from './Product/CreateProduct';

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/product/:productId" element={<ProductPage />} />
        <Route path="/products/list" element={<ProductPage />} />
        <Route path="/product/create" element={<CreateProduct />} />
    </Routes>
);
