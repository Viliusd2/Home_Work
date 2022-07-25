import {useTranslation} from 'react-i18next';
import {Container, Nav} from 'react-bootstrap';
import {useSelector} from 'react-redux';
import "./css/style.css"

const HomePage = () => {
    const {t} = useTranslation();
    const authUser = useSelector((state) => state.user);


    return (
        <>

            <Container>
                <div align="center" className="home">
                    <div className="homeImage">
                        {authUser.username ? (
                        <div className="homeBox">
                            <div>
                                <h2>{t('hello')} {authUser.fullName}
                                </h2>
                            </div>
                        </div>
                        ):(<></>)}
                    </div>
                </div>
            </Container>

        </>
    )
        ;
};
export default HomePage;
