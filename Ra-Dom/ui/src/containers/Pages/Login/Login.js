import './statics/loginStyle.css';
import {Field, Form, Formik} from 'formik';
import {
    Button,
    Container,
    Form as BootstrapForm,
    InputGroup,
} from 'react-bootstrap';

const Login = () => {
    const validate = (login) => {
        const errors = {};

        if (!login.email.includes('@')) {
            errors.email = "CIA NE EMAIL'AS!!!";
        }

        if (login.password.length < 6) {
            errors.password = 'Slaptazodzio ilgis turi buti >= 6';
        }

        return errors;
    };

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={(login, helper) => {
                console.log('login', login);
            }}
            validate={validate}
        >
            {(props) => (
                <div className="Auth-form-container">
                    <Form className="Auth-form">
                        <div className="Auth-form-content">
                            <h3 className="Auth-form-title">Sign In</h3>
                            <div className="form-group mt-3">
                                <Field name="email">
                                    {({ field, form }) => {  // form -> Field form props

                                        console.log('field', field)
                                        console.log('form', form)

                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId='email'>
                                                <BootstrapForm.Label className="label">Email:</BootstrapForm.Label>
                                                <InputGroup >
                                                    <BootstrapForm.Control
                                                        className="form-control mt-1"
                                                        placeholder="Enter Email"
                                                        type='text'
                                                        name={field.name}
                                                        isValid={form.touched[field.name] && isValid}
                                                        isInvalid={isInvalid}
                                                        feedback={form.errors[field.name]}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[field.name]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
                            </div>
                            <div className="form-group mt-3">
                                <Field name="password">
                                    {({ field, form }) => {  // form -> Field form props

                                        console.log('field', field)
                                        console.log('form', form)

                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId='password'>
                                                <BootstrapForm.Label className="label">Password:</BootstrapForm.Label>
                                                <InputGroup >
                                                    <BootstrapForm.Control
                                                        className="form-control mt-1"
                                                        placeholder="Enter Password"
                                                        type='text'
                                                        name={field.name}
                                                        isValid={form.touched[field.name] && isValid}
                                                        isInvalid={isInvalid}
                                                        feedback={form.errors[field.name]}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[field.name]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
                            </div>
                            <div className="d-grid gap-2 mt-3">
                                <Button type='submit'className="btn btn-primary">Submit</Button>
                            </div>
                        </div>
                    </Form>
                </div>
            )}
        </Formik>
    );
};

export default Login;
