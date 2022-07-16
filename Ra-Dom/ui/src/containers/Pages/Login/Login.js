import './statics/loginStyle.css';
import {Field, Form, Formik} from 'formik';
import {Button, Spinner} from 'react-bootstrap';
import FormikFieldInput from "../../../components/Formik/FormikFieldInput";
import * as Yup from 'yup';
import {loginEndpoint} from "../../../api/apiEndpoints";

const Login = () => {
    const validateSchema = Yup.object().shape({
        email: Yup.string()
            .min(5, 'Ilgis turi buti ne mazesnis nei 5')
            .required()
            //.email()
            .matches(/^(.+)@(.+)$/, 'email neatitinka standarto'),
        password: Yup.string()
            .min(6, 'Slaptazodzio ilgis turi buti >= 6')
            .required(),
    });

    const postLogin = (login, helper) => {
        loginEndpoint({
            username: login.email,
            password: login.password,
        }).then((response) =>
            console.log('login response', response),
        )
            .catch((error) => console.log(error))
            .finally(() => helper.setSubmitting(false));
    }

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={postLogin}
            validateSchema={validateSchema}
        >
            {(props) => (
                <div className="Auth-form-container">
                    <Form className="Auth-form">
                        <div className="Auth-form-content">
                            <h3 className="Auth-form-title">Sign In</h3>
                            <div className="form-group mt-3">
                                <Field name='email'
                                       labelText='Email:'
                                       type='text'
                                       component={FormikFieldInput} />
                            </div>
                            <div className="form-group mt-3">
                                <Field name='password'
                                       labelText='Password:'
                                       type='password'
                                       component={FormikFieldInput} />
                            </div>
                            <div className="d-grid gap-2 mt-3">
                                {props.isSubmitting
                                    ? <Button variant='primary' disabled>
                                        <Spinner
                                            as='span'
                                            animation='grow'
                                            size='sm'
                                            role='status'
                                            aria-hidden='true'
                                        />
                                        Processing...
                                    </Button>
                                    :  <Button type='submit'
                                               variant='primary'>
                                        Submit
                                    </Button>
                                }
                            </div>
                        </div>
                    </Form>
                </div>
            )}
        </Formik>
    );
};

export default Login;
