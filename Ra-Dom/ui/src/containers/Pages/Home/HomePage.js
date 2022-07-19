import {useTranslation} from "react-i18next";
import {Container} from "react-bootstrap";

const HomePage = () => {

    const { t } = useTranslation()

    return (
        <>
            <Container className="Auth-form">
                <h1>{t("home")}</h1>
                <h2>{t("hello")}</h2>
            </Container>

        </>
    );
}
export default HomePage;
