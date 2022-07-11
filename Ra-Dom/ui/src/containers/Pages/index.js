import { Route, Routes } from 'react-router-dom';
import HomePage from './Home/HomePage';
import ProductsPage from './Product/ProductsPage';
import CreateProduct from './Product/CreateProduct';

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/product/:productId" element={<ProductsPage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/product/create" element={<CreateProduct />} />
    </Routes>
);
