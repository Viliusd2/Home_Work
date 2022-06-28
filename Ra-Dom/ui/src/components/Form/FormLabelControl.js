import { Form } from 'react-bootstrap';

const FormLabelControl = ({
    classname,
    id,
    labelText,
    placeholderText,
    onchange,
    inputType,
    isTextArea = false,
}) => {
    return (
        <Form.Group className={classname} controlId={id}>
            <Form.Label>{labelText}</Form.Label>
            {isTextArea ? (
                <Form.Control
                    type={inputType}
                    placeholder={placeholderText}
                    onChange={onchange}
                    as="textarea"
                />
            ) : (
                <Form.Control
                    type={inputType}
                    placeholder={placeholderText}
                    onChange={onchange}
                />
            )}
        </Form.Group>
    );
};
export default FormLabelControl;
