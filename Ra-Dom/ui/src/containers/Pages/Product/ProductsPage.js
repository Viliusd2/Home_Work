import { useEffect, useState } from 'react';
import { getProductsListEndpoint } from '../../../api/apiEndpoints';
import { Card, Col, Container, Row } from 'react-bootstrap';
import { useTranslation } from "react-i18next";

const ProductsPage = () => {
    const [productItems, setProductItems] = useState([]);
    const { t } = useTranslation("productList")

    useEffect(() => {
        getProductsListEndpoint()
            .then(({ data }) => {
                setProductItems(data.products);
            })
            .catch((error) => console.log('error', error));
    }, []);

    return (
        <Container fluid>
            <h1 className={'text-center'}>{t("title")}</h1>
            <Row xs={1} md={3} className="g-4">
                {productItems.map((product) => (
                    <Col key={product.productId}>
                        <Card>
                            <Card.Header>
                                <div className="d-flex justify-content-around">
                                    <div>{product.price} Eur</div>
                                    <div>
                                        {product.quantityInStock} {t("stock")}
                                    </div>
                                </div>
                            </Card.Header>
                            <Card.Body>
                                <Card.Title>{product.name}</Card.Title>
                                <Card.Text>{t("flavor")} {product.flavor}</Card.Text>
                                <Card.Text>
                                    {t("portion")} {product.portionSize}
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
