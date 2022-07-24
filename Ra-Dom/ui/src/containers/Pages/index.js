import { Route, Routes, Navigate } from 'react-router-dom';
import NewProductPage from './NewProductPage/NewProductPage';
import { useSelector } from 'react-redux';
import ProductsPage from './ProductList';
import HomePage from './Home/HomePage';
import CartPage from './Cart/CartPage';
import LoginPage from './Login/LoginPage';
import ProductPage from "./Product";
import FileUpload from "./FileUpload/FileUpload";
import Registration from "./Login/User/Registration";


const Pages = () => {
    const userRoles = useSelector((state) => state.user.roles);
    const adminAuthorized = userRoles.includes('ROLE_ADMIN');

    return (
        <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/products" element={<ProductsPage />} />
            {adminAuthorized ? (
                <Route path="/products/create" element={<NewProductPage />} />
            ) : (
                <Route
                    path="/products/create"
                    v
                    element={
                        <Navigate
                            to={{
                                pathname: '/login',
                            }}
                        />
                    }
                />
            )}
            <Route path='/register' element={<Registration />} />
            <Route path='/file/upload' element={<FileUpload />} />
            <Route path='/product/:productId' element={<ProductPage />} />
            <Route path="/cart" element={<CartPage />} />
            <Route path="/login" element={<LoginPage />} />
        </Routes>
    );
};

export default Pages;
