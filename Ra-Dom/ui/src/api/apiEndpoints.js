import HTTP from './axiosConfig';

const getProductsEndpoint = () => HTTP.get("/api/products")

const createProductEndpoint = (productData) => HTTP.post("/products", productData)

export {
    getProductsEndpoint
}