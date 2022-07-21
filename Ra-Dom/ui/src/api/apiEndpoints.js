import HTTP from './axiosConfig';

const getProductsListEndpoint = () => HTTP.get('/products');
const getOneProductEndpoint = (productId) => HTTP.get('/product/' + productId);

const createProductEndpoint = (productData) =>
    HTTP.post('/product/create', productData);

const loginEndpoint = (loginData) => HTTP.post('/login', loginData);

export {
    getProductsListEndpoint,
    loginEndpoint,
    createProductEndpoint,
    getOneProductEndpoint

};
