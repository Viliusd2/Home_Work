import { FaFacebookSquare, FaInstagramSquare } from 'react-icons/fa';
import {useTranslation} from "react-i18next";

const FooterContainer = () => {
    const {t} = useTranslation("footer")
    return (
        <div className="container fixed-bottom">
            <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
                <div className="col-md-4 d-flex align-items-center">
                    <a
                        href="/"
                        className="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1"
                    ></a>
                    <span className="text-muted">© 2021 Ra-Dom Eshop, Inc</span>
                </div>

                <ul className="nav col-md-4 justify-content-end list-styled d-flex">
                    <li className="ms-3">
                        <a className="text-muted" href="#">
                            <FaInstagramSquare/>
                        </a>
                    </li>
                    <li className="ms-3">
                        <a className="text-muted" href="#">
                            <FaFacebookSquare/>
                        </a>
                    </li>
                    <li className="ms-3">
                        <a className="text-muted" href="#">
                            {t("about")}
                        </a>
                    </li>
                </ul>
            </footer>
        </div>
    );
}

export default FooterContainer;
