import React, { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';

function CreateProduct() {
    // Declare multiple state variables!
    const [product, setProduct] = useState({
        name: '',
        price: '',
        amount: '',
        description: '',
    });

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.id]: e.target.value,
        });
    };

    function handleSubmit(e) {
        console.log(product);
        e.preventDefault();
    }
    return (
        <>
            <Container>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-3" controlId="name">
                        <Form.Label>Product Name</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Product Name"
                            onChange={handleChange}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="quantity">
                        <Form.Label>Quantity</Form.Label>
                        <Form.Control
                            type="number"
                            placeholder="Quantity"
                            onChange={handleChange}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="price">
                        <Form.Label>Price</Form.Label>
                        <Form.Control
                            type="number"
                            placeholder="Price"
                            onChange={handleChange}
                        />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="description">
                        <Form.Label>Description</Form.Label>
                        <Form.Control
                            as="textarea"
                            placeholder="Description"
                            onChange={handleChange}
                        />
                    </Form.Group>

                    <Button variant="success" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </>
    );
}
export default CreateProduct;
