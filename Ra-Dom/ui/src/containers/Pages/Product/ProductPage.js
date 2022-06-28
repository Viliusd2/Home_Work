import { useParams } from 'react-router-dom';

const ProductPage = () => {
    const { productId } = useParams();

    return (
        <>
            <h1>Product Id: {productId} </h1>;
        </>
    );
};
export default ProductPage;
