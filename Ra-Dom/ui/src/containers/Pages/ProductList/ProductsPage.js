import {deleteProductEndpoint, getProductsListEndpoint} from '../../../api/apiEndpoints';
import {useEffect, useState} from 'react';
import {Button, Card, Col, Container, Nav, Row, Spinner} from 'react-bootstrap';
import {useTranslation} from 'react-i18next';
import {Link} from "react-router-dom";
import {useSelector} from "react-redux";

const ProductsPage = ({addToCartDA}) => {
    const [productItems, setProductItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const {t} = useTranslation('productList');
    const authUser = useSelector((state) => state.user);

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

    const handleDeleteProduct= (product) => {

        deleteProductEndpoint(product.productId)
            .then(r => {
                console.log(r);
                setProductItems(productItems.filter(item => item.name !== product.name));
            })
            .catch((error) => console.log(error))
    };

    return (
        <Container fluid >
            <h1 className={'text-center'}>Product list</h1>
            <Row xs={1} md={2} xl={3} className="g-4">
                {loading ? (
                    <Spinner className="text-center" animation="border"/>
                ) : (
                    productItems.map((product) => (
                        <Col key={product.productId}>
                            <Card className="Auth-form h-100">
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
                                    <Card.Title>
                                        <div align="center">
                                            <Link to={"/product/" + product.productId}>
                                                {product.name}
                                            </Link>
                                        </div>
                                    </Card.Title>
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
                                        {authUser?.roles.includes('ROLE_ADMIN') && (
                                            <div className="m-2 p-2 d-flex justify-content-center align-items-center">
                                                <Button className="btn-danger" onClick={() => handleDeleteProduct(product)}>
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

    );
};

export default ProductsPage;
