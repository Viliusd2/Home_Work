import { connect } from 'react-redux';
import { addToCart } from '../../../redux/Cart/cartSlice';
import ProductsPage from './ProductsPage';

/**
 * ____DA - Dispatcher action
 */
const mapDispatchToProps = {
    addToCartDA: addToCart,
};

export default connect(null, mapDispatchToProps)(ProductsPage);
