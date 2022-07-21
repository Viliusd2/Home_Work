import { getProductsListEndpoint } from '../../../api/apiEndpoints';
import { useEffect, useState } from 'react';
import { Button, Card, Col, Container, Row, Spinner } from 'react-bootstrap';
import { useTranslation } from 'react-i18next';

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
            <Row xs={1} md={2} className="g-4">
                {loading ? (
                    <Spinner className="text-center" animation="border" />
                ) : (
                    productItems.map((product) => (
                        <Col key={product.productId}>
                            <Card>
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
                                    <Card.Title>{product.name}</Card.Title>
                                    <Card.Text>
                                        {t('flavor')} {product.flavor}
                                    </Card.Text>
                                    <Card.Text>
                                        {t('portion')} {product.portionSize}
                                    </Card.Text>
                                    <Button
                                        onClick={() =>
                                            handleAddProductToCart(product)
                                        }
                                    >
                                        Buy
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))
                )}
            </Row>
        </Container>
    );
};

export default ProductsPage;
