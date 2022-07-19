import {
    Button,
    Container,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
} from 'react-bootstrap';
import {NavLink} from 'react-router-dom';
import {useContext} from 'react';
import {AuthUserContext} from "../../context/AuthUserContext";
import {useTranslation} from "react-i18next";
import * as i18n from "i18next";


const HeaderContainer = () => {


    const {authUser} = useContext(AuthUserContext)
    const {t} = useTranslation("navigation")
    return (
        <Navbar bg="light " expand="lg">
            <Container fluid>
                <Navbar.Brand to="/" as={NavLink}>
                    Eshop Ra-Dom
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll"/>
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{maxHeight: '100px'}}
                        navbarScroll
                    >
                        <Nav.Link to="/product/create" as={NavLink}>
                            {t("createProduct")}
                        </Nav.Link>
                        <Nav.Link to="/products" as={NavLink}>
                            {t("products")}
                        </Nav.Link>
                        <Nav.Link to="/cart" as={NavLink}>
                            {t("cart")}
                        </Nav.Link>

                        <Nav.Link href="#" disabled>
                            {t("registration")}
                        </Nav.Link>
                        <NavDropdown title="Languages" id="navbarScrollingDropdown" onSelect={(eventKey) => i18n.changeLanguage(eventKey)}>
                            <NavDropdown.Item eventKey="lt">{t("lang.lt")}</NavDropdown.Item>
                            <NavDropdown.Item eventKey="en">{t("lang.en")}</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    <Form className="d-flex">
                        <FormControl
                            type="search"
                            placeholder={t("search.placeholder")}
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="outline-success">{t("search.button")}</Button>
                    </Form>
                    {!authUser.username
                        ? <Nav.Link to="/login" as={NavLink}>
                            {t("login")}
                        </Nav.Link>
                        : <Nav.Link href="/login">
                            {t("logout")}
                        </Nav.Link>
                    }
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default HeaderContainer;
