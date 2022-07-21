import { useParams } from 'react-router-dom';
import {Button, Col, Container} from "react-bootstrap";
import {getOneProductEndpoint} from "../../../api/apiEndpoints";
import {useEffect, useState} from "react";
import {useTranslation} from "react-i18next";

const ProductPage = ({addToCartDA}) => {
    const { productId } = useParams(); // destruct param path name from url
    const [productFromDb, setProduct] = useState([]);
    const { t } = useTranslation('productShowcase');

    useEffect(() => {
        getOneProductEndpoint(productId)
            .then(({ data }) => {
                setProduct(data.products);

            })
            .catch((error) => console.log('error', error));
    }, []);

    const handleAddProductToCart = (product) => {
        addToCartDA({
            id: product.productId,
            name: product.name,
            price: product.price,
        })
    };

    return (
    <Container className="Auth-form" >
        {(productFromDb.map((product) => (
            <div key={product.productId}>
            <h1>Selected Product</h1>
            <div>{product.name}</div>
            <div>{product.price}</div>
            <div>{product.quantityInStock}</div>
            <div>{product.portionSize}</div>
            <div>{product.flavor}</div>
            <div>{product.description}</div>
                <Button
                    onClick={() =>
                        handleAddProductToCart(product)
                    }
                >
                    {t("productList:buy")}
                </Button>
        </div>
        )))}
    </Container>
    )
};

export default ProductPage;