import {useParams} from 'react-router-dom';
import {Button, Container} from "react-bootstrap";
import {getOneProductEndpoint, updateProductEndpoint} from "../../../api/apiEndpoints";
import {useEffect, useState} from "react";
import {useTranslation} from "react-i18next";

const ProductPage = ({addToCartDA}) => {
    const {productId} = useParams(); // destruct param path name from url
    const [productFromDb, setProduct] = useState([]);
    const {t} = useTranslation('productShowcase');
    // const authUser = useSelector((state) => state.user);

    useEffect(() => {
        getOneProductEndpoint(productId)
            .then(({data}) => {
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

    // function handleUpdateProduct(product) {
    //     updateProductEndpoint(product)
    //         .then(r=> alert("response status : " + r.status))
    //
    // }

    return (
        <Container className="Auth-form">
            {(productFromDb.map((product) => (
                <div key={product.productId}>

                    <h1>Selected Product</h1>
                    <div>{product.name}</div>
                    <div>{product.price}</div>
                    <div>{product.quantityInStock}</div>
                    <div>{product.portionSize}</div>
                    <div>{product.flavor}</div>
                    <div>{product.description}</div>
                        <div className="m-2 p-2 d-flex justify-content-evenly align-items-center">
                            <Button
                                onClick={() =>
                                    handleAddProductToCart(product)
                                }
                            >
                                {t("buy")}
                            </Button>

                        {/*{authUser?.roles.includes('ROLE_ADMIN') && (*/}
                        {/*        <Button className="btn-outline-success text-black" onClick={() => handleUpdateProduct(product)}>*/}
                        {/*            {t('update')}*/}
                        {/*        </Button>*/}
                        {/*)}*/}
                    </div>
                </div>
            )))}
        </Container>
    )
};

export default ProductPage;