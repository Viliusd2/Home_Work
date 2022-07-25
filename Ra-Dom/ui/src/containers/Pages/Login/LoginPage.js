import './statics/loginStyle.css';
import {Field, Form, Formik} from 'formik';
import {Button, Container, Spinner,} from 'react-bootstrap';
import {loginEndpoint} from '../../../api/apiEndpoints';
import {useNavigate} from 'react-router-dom';
import {useDispatch} from 'react-redux';
import {setLogin} from '../../../redux/User/userActions';
import {useTranslation} from "react-i18next";
import Yup from "../../../validation"
import FormikFieldInput from "../../../components/Formik/FormikFieldInput";

const validationSchema = Yup.object().shape({
    email: Yup.string()
        .required()
        .matches(/^(.+)@(.+)$/)
        .label("login:label.email"),
    password: Yup.string()
        .required()
        .label("login:label.pass"),
});

const LoginPage = () => {

    const navigate = useNavigate()
    const {t} = useTranslation("login")
    const dispatch = useDispatch()

    const postLogin = (login, helper) => {
        loginEndpoint({
            username: login.email,
            password: login.password,
        }).then(({data}) => {
            dispatch(
                setLogin(data)
            )
            navigate("/")
        })
            .catch((error) => console.log(error))
            .finally(() => helper.setSubmitting(false))
    };

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={postLogin}
            validationSchema={validationSchema}
        >
            {
                props =>
                    <Container className="Auth-form-container">
                        <Form className="Auth-form">
                            <div className="Auth-form-content">
                                <h3 className="Auth-form-title">{t('title')}</h3>
                            <div className="form-group mt-3">
                                <Field name='email'
                                       labelText={t('label.email')}
                                       type='text'
                                    component={FormikFieldInput}
                                />
                            </div>
                            <div className="form-group mt-3">
                                <Field name='password'
                                       labelText={t('label.pass')}
                                       type='password'
                                       component={FormikFieldInput}/>
                            </div>
                                <div className='text-center'>
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
                                        : <Button type='submit'
                                                  variant='primary'>
                                            {t("button")}
                                        </Button>
                                    }
                                </div>
                            </div>
                        </Form>
                    </Container>
            }
        </Formik>
    );
};

export default LoginPage;
