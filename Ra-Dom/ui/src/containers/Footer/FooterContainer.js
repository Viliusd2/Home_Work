import { FaInstagramSquare } from 'react-icons/fa';
import { useTranslation } from 'react-i18next';

const FooterContainer = () => {
    const { t } = useTranslation('footer');

    return (
        <footer className="container bg-dark bg-opacity-25 w-100 text-dark ">
            <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
                <div className="col-md-4 d-flex align-items-center">
                    <a
                        href="/"
                        className="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1"
                    ></a>
                    <span className="text-opacity-50">© 2021 Ra-Dom Eshop, Inc</span>
                </div>

                <ul className="nav col-md-4 justify-content-end list-styled d-flex">
                    <li className="ms-3">
                        <a className="text-opacity-50"
                           href="https://www.instagram.com/radom_sweets/?hl=en"
                           target="_blank"
                           rel="noopener noreferrer">
                            <FaInstagramSquare />
                        </a>
                    </li>
                    <li className="ms-3">
                        <div className="text-opacity-50" href="#">
                            {t('about')}
                        </div>
                    </li>
                </ul>
            </footer>
        </footer>
    );
};

export default FooterContainer;
