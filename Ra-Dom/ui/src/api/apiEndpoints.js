import HTTP from './axiosConfig';

const getProductsListEndpoint = () => HTTP.get("/products")

const createProductEndpoint = (productData) => HTTP.post("/products", productData)

export {
    getProductsListEndpoint
}