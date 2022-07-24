import { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import { createProductEndpoint } from '../../../api/apiEndpoints';
import { useTranslation } from 'react-i18next';
import FormLabelControl from '../../../components/Form/FormLabelControl';
import FileUpload from "../FileUpload/FileUpload";

const NewProductPage = () => {
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
    const { t } = useTranslation("productForm")


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
            .finally(e.target.reset())


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
            <Container className={"d-flex justify-content-center align-items-center NewProduct-form"}>
            <Container>
                <Form onSubmit={onSubmit}>
                    <FormLabelControl
                        id="name"
                        labelText={t("labels.name")}
                        placeholderText={t("placeholders.name")}
                        onchange={handleChange}
                        inputType="text"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="quantityInStock"
                        labelText={t("labels.quantityInStock")}
                        placeholderText={t("placeholders.quantityInStock")}
                        onchange={handleChange}
                        inputType="number"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="portionSize"
                        labelText={t("labels.portionSize")}
                        placeholderText={t("placeholders.portionSize")}
                        onchange={handleChange}
                        inputType="number"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="price"
                        labelText={t("labels.price")}
                        placeholderText={t("placeholders.price")}
                        onchange={handleChange}
                        inputType="number"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="flavor"
                        labelText={t("labels.flavor")}
                        placeholderText={t("placeholders.flavor")}
                        onchange={handleChange}
                        inputType="text"
                        classname="mb-3"
                    />
                    <FormLabelControl
                        id="description"
                        labelText={t("labels.description")}
                        placeholderText={t("placeholders.description")}
                        onchange={handleChange}
                        inputType="text"
                        classname="mb-5"
                        isTextArea
                    />

                    <Button variant="success" type="submit">
                        {t("common:buttons.submit")}
                    </Button>
                </Form>
                {showCreatedProductInfo()}
            </Container>
                <FileUpload />
            </Container>

        </>
    );
}

export default NewProductPage;
