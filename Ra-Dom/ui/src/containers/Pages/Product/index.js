import { connect } from 'react-redux';
import ProductPage from "./ProductPage";
import { addToCart } from "../../../redux/Cart/cartSlice";


/**
 * ____DA - Dispatcher action
 */
const mapDispatchToProps = {
    addToCart: addToCart,
};

export default connect(null, mapDispatchToProps)(ProductPage);
