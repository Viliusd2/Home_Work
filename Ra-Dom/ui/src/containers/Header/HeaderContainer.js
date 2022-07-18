import {
    Button,
    Container,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
} from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import { useContext } from 'react';
import {AuthUserContext} from "../../context/AuthUserContext";


const HeaderContainer = () => {

const { authUser } = useContext(AuthUserContext)

return (
<Navbar bg="light " expand="lg">
        <Container fluid>
            <Navbar.Brand to="/" as={NavLink}>
                Eshop Ra-Dom
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
                <Nav
                    className="me-auto my-2 my-lg-0"
                    style={{ maxHeight: '100px' }}
                    navbarScroll
                >
                    <Nav.Link to="/product/create" as={NavLink}>
                        Create Product
                    </Nav.Link>
                    <Nav.Link to="/products" as={NavLink}>
                        Products
                    </Nav.Link>
                    <Nav.Link to="/cart" as={NavLink}>
                        Cart
                    </Nav.Link>

                    <Nav.Link href="#" disabled>
                        Registration
                    </Nav.Link>
                    <NavDropdown title="Language" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#action3">
                            Lietuviu
                        </NavDropdown.Item>
                        <NavDropdown.Item href="#action4">
                            English
                        </NavDropdown.Item>
                    </NavDropdown>
                </Nav>
                <Form className="d-flex">
                    <FormControl
                        type="search"
                        placeholder="Search"
                        className="me-2"
                        aria-label="Search"
                    />
                    <Button variant="outline-success">Search</Button>
                </Form>
                {!authUser.username
                    ? <Nav.Link to="/login" as={NavLink}>
                        Login
                    </Nav.Link>
                    : <Nav.Link href="/login">
                        Logout
                    </Nav.Link>
                }
            </Navbar.Collapse>
        </Container>
    </Navbar>
);
}

export default HeaderContainer;
