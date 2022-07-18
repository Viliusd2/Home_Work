import React, {useContext, useState} from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import FormLabelControl from '../../../components/Form/FormLabelControl';
import {createProductEndpoint} from "../../../api/apiEndpoints";

function NewProductCreationPage() {
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
    const [message, setMessage] = useState(false);


    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.id]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();
        createProductEndpoint(product)
            .then((response) => setMessage(true))

    };

    const showCreatedProductInfo = () => {
        const {
            name,
            quantityInStock,
            portionSize,
            flavor,
            price,
            description,
        } = product;
        return (
            message && (
                <>
                    <hr />
                    <div>
                        Product Created:
                        <div>{name}</div>
                        <div>{price}</div>
                        <div>{quantityInStock}</div>
                        <div>{portionSize}</div>
                        <div>{flavor}</div>
                        <div>{description}</div>
                    </div>
                </>
            )
        );
    };

    return (
        <>
            <Container>
                <Form onSubmit={onSubmit}>
                    <FormLabelControl
                        id="name"
                        labelText="Product name"
                        placeholderText="Enter product name"
                        onchange={handleChange}
                        inputType="text"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="quantityInStock"
                        labelText="Quantity In Stock"
                        placeholderText="Enter quantity"
                        onchange={handleChange}
                        inputType="number"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="portionSize"
                        labelText="Portion Size"
                        placeholderText="Enter portion size"
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
                        id="flavor"
                        labelText="Flavor"
                        placeholderText="Enter flavor"
                        onchange={handleChange}
                        inputType="text"
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
                {showCreatedProductInfo()}
            </Container>
        </>
    );
}
export default NewProductCreationPage;
