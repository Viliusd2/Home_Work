import { connect } from 'react-redux';
import {addToCart, removeFromCart} from '../../../../redux/Cart/cartSlice';
import ProductsPage from './ProductsPage';

/**
 * ____DA - Dispatcher action
 */
const mapDispatchToProps = {
    addToCartDA: addToCart,
    removeFromCartByProductId: removeFromCart,
};

export default connect(null, mapDispatchToProps)(ProductsPage);
