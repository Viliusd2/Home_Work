import {deleteProductEndpoint, getProductsListEndpoint} from '../../../../api/apiEndpoints';
import {useEffect, useState} from 'react';
import {Button, Card, Col, Container, Row, Spinner} from 'react-bootstrap';
import {useTranslation} from 'react-i18next';
import {Link} from "react-router-dom";
import {useSelector} from "react-redux";
import newProductPage from "../NewProduct/NewProductPage";
import './style.css'

const ProductsPage = ({addToCartDA, removeFromCartByProductId}) => {
    const [productItems, setProductItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const {t} = useTranslation('productList');
    const authUser = useSelector((state) => state.user);
    const baseUrl = "http://localhost:8080/api/file/download?fileName=";

    useEffect(() => {
        getProductsListEndpoint()
            .then(({data}) => {
                setProductItems(data.products);
            })
            .catch((error) => console.log('error', error))
            .finally(() => setLoading(false));
    }, []);

    const handleAddProductToCart = (product) => {

        addToCartDA({
            id: product.productId,
            name: product.name,
            price: product.price,
        });
    };
    const handleProductUpdate = (product) => {
        newProductPage(product);
    }
    const removeProductById = (id) => removeFromCartByProductId(id);
    const handleDeleteProduct = (product) => {

        deleteProductEndpoint(product.productId)
            .then(r => {
                console.log(r);
                removeProductById(product.productId)
                setProductItems(productItems.filter(item => item.name !== product.name));
            })
            .catch((error) => console.log(error))
    };


    return (
        <>
            <Container>
                <h1 className={'container text-center w-50 bg-light bg-opacity-50 text-dark'}>{t('title')}</h1>
                <Row xs={1} md={2} xl={3} className="g-4">
                    {loading ? (
                        <Spinner className="text-center" animation="border"/>
                    ) : (
                        productItems.map((product) => (
                            <Col key={product.productId}>
                                <Card className="cardBody">
                                    <Card.Title>
                                        <div align="center" className={'cardTitle'}>
                                            <Link to={"/product/" + product.productId}>
                                                {product.name}
                                            </Link>
                                        </div>
                                    </Card.Title>
                                    <div className={'productImage'}>
                                        <img src={baseUrl + product.fileName} alt="" className={"card-img"}/>
                                    </div>
                                    <Card.Header>
                                        <div className="d-flex justify-content-around">
                                            <div>{product.price} Eur</div>
                                            <div>
                                                {product.quantityInStock}{' '}
                                                {t('stock')}
                                            </div>
                                        </div>
                                    </Card.Header>
                                    <Card.Body>
                                        <div className="d-flex justify-content-sm-evenly">
                                            <div className="m-2 p-2 d-flex justify-content-center align-items-center">
                                                <Button
                                                    onClick={() =>
                                                        handleAddProductToCart(product)
                                                    }
                                                >
                                                    {t("buy")}
                                                </Button>
                                            </div>
                                            <div className="m-2 p-2 d-flex justify-content-center align-items-center">
                                                <Button
                                                    onClick={() =>
                                                        handleProductUpdate(product)
                                                    }
                                                >
                                                    update
                                                </Button>
                                            </div>
                                            {authUser?.roles.includes('ROLE_ADMIN') && (
                                                <div
                                                    className="m-2 p-2 d-flex justify-content-center align-items-center">
                                                    <Button className="btn-danger"
                                                            onClick={() => handleDeleteProduct(product)}>
                                                        {t("delete")}
                                                    </Button>
                                                </div>
                                            )}
                                        </div>
                                    </Card.Body>
                                </Card>
                            </Col>
                        ))
                    )}
                </Row>

            </Container>
        </>

    );
};

export default ProductsPage;
