import '../statics/loginStyle.css';
import {Field, Form, Formik} from 'formik';
import {Button, Container, Spinner,} from 'react-bootstrap';
import {useNavigate} from 'react-router-dom';
import {useDispatch} from 'react-redux';
import {useTranslation} from "react-i18next";
import Yup from "../../../../validation"
import '../statics/loginStyle.css';
import {loginEndpoint, registerUserEndpoint} from "../../../../api/apiEndpoints";
import FormikFieldInput from "../../../../components/Formik/FormikFieldInput";
import {setLogin} from "../../../../redux/User/userActions";

const validationSchema = Yup.object().shape({
    name: Yup.string()
        .min(3)
        .max(50)
        .required()
        .label('registration:label.name'),
    surname: Yup.string()
        .min(3)
        .max(100)
        .required()
        .label('registration:label.surname'),
    email: Yup.string()
        .min(5)
        .required()
        .matches(/^(.+)@(.+)$/)
        .label('registration:label.email'),
    password: Yup.string()
        .min(4)
        .required()
        .label('registration:label.password'),
    phoneNumber: Yup.string()
        .min(6)
        .required()
        .label('registration:label.phoneNumber'),
});

const Registration = () => {

    const navigate = useNavigate();
    const {t} = useTranslation('registration');
    const dispatch = useDispatch();

    const postUser = (user, helper) => {
        registerUserEndpoint(user).then(r =>
            alert('successfully created account: ' + r.status)
        ).catch((error) => console.log(error))
            .finally(() => helper.setSubmitting(false));

        loginAfterCreation(user);
    };

    const loginAfterCreation = (user, helper) => {

        loginEndpoint({
            username: user.email,
            password: user.password,
        })
            .then(({data}) => {
                dispatch(setLogin(data));
                navigate('/');
            })
            .catch((error) => console.log(error))

    }

    return (
        <Formik
            initialValues={{
                name: '',
                surname: '',
                email: '',
                password: '',
                phoneNumber: '',
            }}
            onSubmit={postUser}
            validationSchema={validationSchema}
        >
            {props =>
                <Container className="Auth-form-container">
                    <Form className="Auth-form">
                        <div className="Auth-form-content">
                            <h3 className="Auth-form-title">{t('title')}</h3>
                            <div className="form-group mt-3">
                                <Field
                                    name="name"
                                    labelText={t('label.name')}
                                    type="text"
                                    component={FormikFieldInput}/>
                            </div>
                            <div className="form-group mt-3">
                                <Field
                                    name="surname"
                                    labelText={t('label.surname')}
                                    type="text"
                                    component={FormikFieldInput}/>
                            </div>
                            <div className="form-group mt-3">
                                <Field
                                    name="phoneNumber"
                                    labelText={t('label.phoneNumber')}
                                    type="number"
                                    component={FormikFieldInput}/>
                            </div>
                            <div className="form-group mt-3">
                                <Field
                                    name="email"
                                    labelText={t('label.email')}
                                    type="text"
                                    component={FormikFieldInput}/>
                            </div>
                            <div className="form-group mt-3">
                                <Field
                                    name="password"
                                    labelText={t('label.pass')}
                                    type="password"
                                    component={FormikFieldInput}/>
                            </div>

                            <div className="text-center">
                                {props.isSubmitting
                                    ? <Button variant="primary" disabled>
                                        <Spinner
                                            as="span"
                                            animation="grow"
                                            size="sm"
                                            role="status"
                                            aria-hidden="true"
                                        />
                                        Processing...
                                    </Button>
                                    :
                                    <Button type="submit" variant="primary">
                                        {t('button')}
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
export default Registration