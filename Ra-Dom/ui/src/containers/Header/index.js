import {
    Button,
    Container,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
} from 'react-bootstrap';
import { Link, NavLink } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { cartTotalItemsCountSelector } from '../../redux/Cart/cartSelector';
import { useTranslation } from 'react-i18next';

const HeaderContainer = () => {
    const authUser = useSelector((state) => state.user);

    const numberOfCartItems = useSelector((state) =>
        cartTotalItemsCountSelector(state)
    );

    const { t, i18n } = useTranslation('navigation');

    return (
        <Navbar bg="light" expand="lg">
            <Container fluid>
                <Navbar.Brand to="/" as={NavLink}>
                    E-Shop
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link to="/products" as={NavLink}>
                            {t('products')}
                        </Nav.Link>
                        {!authUser.username ? (
                            <>
                                <Nav.Link to="/register" as={NavLink}>
                                    {t('registration')}
                                </Nav.Link>
                            </>
                        ):(<></>)}
                        {authUser?.roles.includes('ROLE_ADMIN') && (
                            <>
                                <Nav.Link to="/products/create" as={NavLink}>
                                    {t('createProduct')}
                                </Nav.Link>
                            </>
                        )}
                    </Nav>
                    <Nav>
                        <Nav.Link to="/cart" as={NavLink}>
                            {t('cart')} {numberOfCartItems}
                        </Nav.Link>
                    </Nav>
                    <NavDropdown
                        title={t('lang.main')}
                        id="navbarScrollingDropdown"
                        onSelect={(eventKey) => i18n.changeLanguage(eventKey)}
                    >
                        <NavDropdown.Item eventKey="lt">
                            {t('lang.lt')}
                        </NavDropdown.Item>
                        <NavDropdown.Item eventKey="en">
                            {t('lang.en')}
                        </NavDropdown.Item>
                    </NavDropdown>
                    <Form className="d-flex">
                        <FormControl
                            type="search"
                            placeholder={t('search.placeholder')}
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="outline-success">
                            {t('search.button')}
                        </Button>
                    </Form>
                    {!authUser.username ? (
                        <Nav.Link to="/login" as={NavLink}>
                            {t('login')}
                        </Nav.Link>
                    ) : (
                        <Nav.Link href="/login">{t('logout')}</Nav.Link>
                    )}
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default HeaderContainer;
