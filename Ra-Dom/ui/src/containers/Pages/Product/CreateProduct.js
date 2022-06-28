import React, { useState } from 'react';
import {Alert, Button, Container, Form} from 'react-bootstrap';
import FormLabelControl from '../../../components/Form/FormLabelControl';

function CreateProduct() {
    // Declare multiple state variables!
    const [product, setProduct] = useState({
        name: '',
        price: '',
        quantity: '',
        description: '',
        success: false
    });
    const [message , sendMessage] = useState(false)

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.id]: e.target.value,
        });
    };

    function handleSubmit(e) {
        console.log(product);
        e.preventDefault();
        sendMessage(true)
    }

    return (
        <>
            <Container>
                <Form onSubmit={handleSubmit}>
                    <FormLabelControl
                        id="name"
                        labelText="Product name"
                        placeholderText="Enter product name"
                        onchange={handleChange}
                        inputType="text"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="quantity"
                        labelText="Quantity"
                        placeholderText="Enter quantity"
                        onchange={handleChange}
                        inputType="number"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="price"
                        labelText="Price"
                        placeholderText="Enter price"
                        onchange={handleChange}
                        inputType="number"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="description"
                        labelText="Description"
                        placeholderText="Enter a description"
                        onchange={handleChange}
                        inputType="text"
                        classname="mb-5"
                        isTextArea
                    />

                    <Button variant="success" type="submit">
                        Submit
                    </Button>
                    {message &&
                        <>
                        <p>{product.name}</p>
                            <p>{product.price}</p>
                            <p>{product.quantity}</p>
                            <p>{product.description}</p>
                        </>

                    }
                </Form>
            </Container>
        </>
    );
}
export default CreateProduct;
