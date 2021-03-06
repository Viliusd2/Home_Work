import HTTP from './axiosConfig';

const getProductsListEndpoint = () => HTTP.get('/products');
const getOneProductEndpoint = (productId) => HTTP.get('/product/' + productId);
const createProductEndpoint = (productData) => HTTP.post('/product/create', productData);

const fileUploadEndpoint = (fileData) => HTTP.post('/file/upload', fileData);

const loginEndpoint = (loginData) => HTTP.post('/login', loginData);
const registerUserEndpoint = (userData) => HTTP.post('/register', userData);
export {
    //products
    getProductsListEndpoint,
    createProductEndpoint,
    getOneProductEndpoint,
    //file
    fileUploadEndpoint,
    //user
    loginEndpoint,
    registerUserEndpoint

};
