import HTTP from './axiosConfig';

const getProductsListEndpoint = () => HTTP.get('/products');
const getOneProductEndpoint = (productId) => HTTP.get('/product/' + productId);
const createProductEndpoint = (productData) => HTTP.post('/product/create', productData);
const deleteProductEndpoint = (productId) => HTTP.delete('/product/' + productId);
const updateProductEndpoint = (productData) => HTTP.put('/product/update', productData);

const fileUploadEndpoint = (fileData) => HTTP.post('/file/upload', fileData);
const fileDownloadEndpoint= (fileName) => HTTP.get('/file/download',fileName);

const loginEndpoint = (loginData) => HTTP.post('/login', loginData);
const registerUserEndpoint = (userData) => HTTP.post('/register', userData);
export {
    //products
    getProductsListEndpoint,
    createProductEndpoint,
    getOneProductEndpoint,
    deleteProductEndpoint,
    updateProductEndpoint,

    //file
    fileUploadEndpoint,
    fileDownloadEndpoint,

    //user
    loginEndpoint,
    registerUserEndpoint

};
