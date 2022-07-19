import { useEffect, useState } from 'react';
import { getProductsListEndpoint } from '../../../api/apiEndpoints';
import { Card, Col, Container, Row } from 'react-bootstrap';
import {Link} from "react-router-dom";

const ProductsPage = () => {
    const [productItems, setProductItems] = useState([]);

    useEffect(() => {
        getProductsListEndpoint()
            .then(({ data }) => {
                setProductItems(data.products);
            })
            .catch((error) => console.log('error', error));
    }, []);

    return (
        <Container fluid>
            <h1 className={'text-center'}>Product list</h1>
            <Row xs={1} md={3} className="g-4">
                {productItems.map((product) => (
                    <Col key={product.productId}>
                        <Card>
                            <Card.Header>
                                <div className="d-flex justify-content-around">
                                    <div>{product.price} Eur</div>
                                    <div>
                                        {product.quantityInStock} available
                                    </div>
                                </div>
                            </Card.Header>
                            <Card.Body>
                                <Card.Title><Link >{product.name}</Link></Card.Title>
                                <Card.Text>Flavor: {product.flavor}</Card.Text>
                                <Card.Text>
                                    Portion size: {product.portionSize}
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    );
};
export default ProductsPage;
