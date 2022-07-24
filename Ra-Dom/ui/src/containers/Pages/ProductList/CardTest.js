import {Button, Card} from "react-bootstrap";
import {Link} from "react-router-dom";
import '../Login/statics/loginStyle.css'

const CardTest = () => {

    return  (
        <Card className="Auth-form">
        <Card.Header>
            <div className="d-flex justify-content-around">
                <div>Kaina Eur</div>
                <div>
                    kiekis {' '}
                    stock
                </div>
            </div>
        </Card.Header>
        <Card.Body>
            <Card.Title > <div align="center">
                <Link to={'/'} >
                    Product name
                </Link>
            </div></Card.Title>
            <div className="d-flex justify-content-center">
                <div className="m-2 p-3">
                    <h6>flavor</h6>
                    <Card.Text>
                        product.flavor
                    </Card.Text>
                    <h6>portion </h6>
                    <Card.Text>
                        product.portionSize
                    </Card.Text>
                </div >
                <div className="m-2 p-2 d-flex justify-content-center">
                    <Button>
                        buy
                    </Button>
                </div>
            </div>


        </Card.Body>
    </Card>)
}
export default CardTest