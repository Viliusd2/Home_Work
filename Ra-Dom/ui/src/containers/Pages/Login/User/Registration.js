import {useNavigate} from "react-router-dom";
import {useTranslation} from "react-i18next";
import {useDispatch} from "react-redux";
import {loginEndpoint, registerUserEndpoint} from "../../../../api/apiEndpoints";
import {setLogin} from "../../../../redux/User/userActions";
import {Field, Form, Formik} from "formik";
import FormikFieldInput from "../../../../components/Formik/FormikFieldInput";
import {Button, Spinner} from "react-bootstrap";
import Yup from "../../../../validation";
const validateSchema = Yup.object().shape({
    email: Yup.string()
        .min(5)
        .required()
        .matches(/^(.+)@(.+)$/)
        .label('label.email'),
    password: Yup.string()
        .min(4)
        .required()
        .label('label.password'),
});

const Registration = () => {

const navigate = useNavigate();
const { t } = useTranslation('registration');
const dispatch = useDispatch();

const postUser = (user, helper) => {
    registerUserEndpoint(user).then(r =>
    alert('successfully created account: ' + r.status)
    )

    loginEndpoint({
        username: user.email,
        password: user.password,
    })
        .then(({ data }) => {
            dispatch(setLogin(data));
            navigate('/');
        })
        .catch((error) => console.log(error))
        .finally(() => helper.setSubmitting(false));
};

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
        validateSchema={validateSchema}
    >
        {(props) => (
            <div className="Auth-form-container">
                <Form className="Auth-form">
                    <div className="Auth-form-content">
                        <h3 className="Auth-form-title">{t('title')}</h3>
                        <div className="form-group mt-3">
                            <Field
                                name="name"
                                labelText={t('label.name')}
                                type="text"
                                component={FormikFieldInput}
                            />
                        </div>
                        <div className="form-group mt-3">
                            <Field
                                name="surname"
                                labelText={t('label.surname')}
                                type="text"
                                component={FormikFieldInput}
                            />
                        </div>
                        <div className="form-group mt-3">
                            <Field
                                name="phoneNumber"
                                labelText={t('label.phoneNumber')}
                                type="number"
                                component={FormikFieldInput}
                            />
                        </div>
                        <div className="form-group mt-3">
                            <Field
                                name="email"
                                labelText={t('label.email')}
                                type="text"
                                component={FormikFieldInput}
                            />
                        </div>
                        <div className="form-group mt-3">
                            <Field
                                name="password"
                                labelText={t('label.pass')}
                                type="password"
                                component={FormikFieldInput}
                            />
                        </div>
                        <div className="d-grid gap-2 mt-3">
                            {props.isSubmitting ? (
                                <Button variant="primary" disabled>
                                    <Spinner
                                        as="span"
                                        animation="grow"
                                        size="sm"
                                        role="status"
                                        aria-hidden="true"
                                    />
                                    Processing...
                                </Button>
                            ) : (
                                <Button type="submit" variant="primary">
                                    {t('button')}
                                </Button>
                            )}
                        </div>
                    </div>
                </Form>
            </div>
        )}
    </Formik>
);
};
export default Registration