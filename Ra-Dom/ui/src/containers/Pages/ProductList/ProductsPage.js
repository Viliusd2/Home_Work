import { getProductsListEndpoint } from '../../../api/apiEndpoints';
import { useEffect, useState } from 'react';
import { Button, Card, Col, Container, Row, Spinner } from 'react-bootstrap';
import { useTranslation } from 'react-i18next';
import {Link} from "react-router-dom";
import CardTest from "./CardTest";

const ProductsPage = ({ addToCartDA }) => {
    const [productItems, setProductItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const { t } = useTranslation('productList');

    useEffect(() => {
        getProductsListEndpoint()
            .then(({ data }) => {
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

    return (
        <Container fluid>
            <h1 className={'text-center'}>Product list</h1>
            <Row xs={1} md={2} xl={3} className="g-4">
                {loading ? (
                    <Spinner className="text-center" animation="border" />
                ) : (
                    productItems.map((product) => (
                        <Col key={product.productId}>
                            <Card className="Auth-form">
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
                                    <Card.Title > <div align="center">
                                        <Link to={"/product/" + product.productId} >
                                            {product.name}
                                        </Link>
                                    </div></Card.Title>
                                    <div className="d-flex justify-content-center">
                                        <div className="m-2 p-3">
                                            <h6>{t('flavor')}</h6>
                                        <Card.Text>
                                             {product.flavor}
                                        </Card.Text>
                                            <h6>{t('portion')} </h6>
                                        <Card.Text>
                                            {product.portionSize}
                                        </Card.Text>
                                    </div >
                                        <div className="m-2 p-2 d-flex justify-content-center">
                                            <Button
                                                onClick={() =>
                                                    handleAddProductToCart(product)
                                                }
                                            >
                                                {t("buy")}
                                            </Button>
                                        </div>
                                    </div>


                                </Card.Body>
                            </Card>
                        </Col>
                    ))
                )}
            </Row>
            <CardTest/>
        </Container>

    );
};

export default ProductsPage;
