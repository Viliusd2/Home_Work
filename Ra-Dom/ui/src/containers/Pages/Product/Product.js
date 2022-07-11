import React, { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import FormLabelControl from '../../../components/Form/FormLabelControl';

function Product() {
    // Declare multiple state variables!
    const [product, setProduct] = useState({
        name: '',
        price: '',
        flavor: '',
        quantityInStock: '',
        portionSize: '',
        description: '',
        success: false,
    });
    const [message, sendMessage] = useState(false);

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.id]: e.target.value,
        });
    };

    function handleSubmit(e) {
        console.log(product);
        e.preventDefault();
        sendMessage(true);
    }
    const showCreatedProductInfo = () => {
        const {name, quantityInStock,portionSize,flavor, price, description} = product;
 return message &&
        <>
            <hr/>
            <div>
                Created Product:
                <div>{name}</div>
                <div>{price}</div>
                <div>{quantityInStock}</div>
                <div>{portionSize}</div>
                <div>{flavor}</div>
                <div>{description}</div>
            </div>
        </>
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
                </Form>
                { showCreatedProductInfo() }
            </Container>
        </>
    );
}
export default Product;
