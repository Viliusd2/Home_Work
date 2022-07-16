import HTTP from './axiosConfig';

const getProductsListEndpoint = () => HTTP.get('/products');

const createProductEndpoint = (productData) =>
    HTTP.post('/products', productData);

/**
 * i.e. loginData:
 * {
 *     username: string;
 *     password: string;
 * }
 * @param loginData
 * @returns {Promise<AxiosResponse<any>>}
 */
const loginEndpoint = (loginData) => HTTP.post("/login", loginData)










export {
    getProductsListEndpoint ,
    loginEndpoint,
};

