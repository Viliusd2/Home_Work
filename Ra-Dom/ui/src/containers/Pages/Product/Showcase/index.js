import { connect } from 'react-redux';
import ProductShowcasePage from "./ProductShowcasePage";
import {addToCart} from "../../../../redux/Cart/cartSlice";

/**
 * ____DA - Dispatcher action
 */
const mapDispatch = {
    addToCartDA: addToCart
};

export default connect(null, mapDispatch)(ProductShowcasePage);
