import { Route, Routes, Navigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import Registration from "./Login/User/Registration";
import ProductShowcasePage from "./Product/Showcase";
import CartPage from "./Cart/CartPage";
import LoginPage from "./Login/LoginPage";
import NewProductPage from "./Product/NewProduct/NewProductPage";
import ProductsPage from "./Product/ProductsList";
import HomePage from "./Home/HomePage";

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
            <Route path='/product/:productId' element={<ProductShowcasePage />} />
            <Route path="/cart" element={<CartPage />} />
            <Route path="/login" element={<LoginPage />} />
        </Routes>
    );
};

export default Pages;
