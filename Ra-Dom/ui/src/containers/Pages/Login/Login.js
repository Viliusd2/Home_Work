import './statics/loginStyle.css';
import { Form, Formik } from 'formik';

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
                                <label>Email address</label>
                                <input
                                    type="email"
                                    className="form-control mt-1"
                                    placeholder="Enter email"
                                    onChange={props.handleChange}
                                    onBlur={props.handleBlur}
                                    value={props.values.name}
                                />
                                {props.errors.email && (
                                    <span>{props.errors.email}</span>
                                )}
                            </div>
                            <div className="form-group mt-3">
                                <label>Password</label>
                                <input
                                    type="password"
                                    className="form-control mt-1"
                                    placeholder="Enter password"
                                    onChange={props.handleChange}
                                    onBlur={props.handleBlur}
                                    value={props.values.name}
                                />
                                {props.errors.password && (
                                    <span>{props.errors.password}</span>
                                )}
                            </div>
                            <div className="d-grid gap-2 mt-3">
                                <button
                                    type="submit"
                                    className="btn btn-primary"
                                >
                                    Submit
                                </button>
                            </div>
                        </div>
                    </Form>
                </div>
            )}
        </Formik>
    );
};

export default Login;
