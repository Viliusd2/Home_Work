import { useTranslation } from 'react-i18next';
import { Container } from 'react-bootstrap';
import { useSelector } from 'react-redux';

const HomePage = () => {
    const { t } = useTranslation();
    const authUser = useSelector((state) => state.user);

    return (
        <>
            <Container className="Auth-form">
                <h1>{t('home')}</h1>
                <h2>{t('hello')}</h2>
                <div>
                    <strong>{authUser.fullName}</strong>
                </div>
            </Container>
        </>
    );
};
export default HomePage;
