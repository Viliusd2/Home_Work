import { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import { createProductEndpoint } from '../../../api/apiEndpoints';
import { useTranslation } from 'react-i18next';
import FormLabelControl from '../../../components/Form/FormLabelControl';

const NewProductPage = () => {
    const [product, setProduct] = useState({
        name: '',
        price: '',
        flavor: '',
        quantityInStock: '',
        portionSize: '',
        description: '',
    });
    const [visible, setVisible] = useState(false);

    const { t } = useTranslation('productForm');

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();

        createProductEndpoint(product).then((response) => setVisible(true));
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
            visible && (
                <>
                    <hr />
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
            )
        );
    };

    return (
        <Container>
            <Form onSubmit={onSubmit}>
                <FormLabelControl
                    id="name"
                    labelText={t('labels.name')}
                    placeholderText={t('placeholders.name')}
                    onchange={handleChange}
                    inputType="text"
                    classname="mb-3"
                />
                <FormLabelControl
                    id="quantityInStock"
                    labelText={t('labels.quantityInStock')}
                    placeholderText={t('placeholders.quantityInStock')}
                    onchange={handleChange}
                    inputType="number"
                    classname="mb-3"
                />
                <FormLabelControl
                    id="portionSize"
                    labelText={t('labels.portionSize')}
                    placeholderText={t('placeholders.portionSize')}
                    onchange={handleChange}
                    inputType="number"
                    classname="mb-3"
                />
                <FormLabelControl
                    id="price"
                    labelText={t('labels.price')}
                    placeholderText={t('placeholders.price')}
                    onchange={handleChange}
                    inputType="number"
                    classname="mb-3"
                />
                <FormLabelControl
                    id="flavor"
                    labelText={t('labels.flavor')}
                    placeholderText={t('placeholders.flavor')}
                    onchange={handleChange}
                    inputType="text"
                    classname="mb-3"
                />
                <FormLabelControl
                    id="description"
                    labelText={t('labels.description')}
                    placeholderText={t('placeholders.description')}
                    onchange={handleChange}
                    inputType="text"
                    classname="mb-5"
                    isTextArea
                />

                <Button variant="success" type="submit">
                    {t('common:buttons.submit')}
                </Button>
            </Form>
            {showCreatedProductInfo()}
        </Container>
    );
};

export default NewProductPage;
