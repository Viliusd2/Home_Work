import React, {useState} from "@types/react";


function OpenProductPage() {
    // Declare multiple state variables!
    const [product, setProduct] = useState({
        name: '',
        price: '',
        flavor: '',
        quantityInStock: '',
        portionSize: '',
        description: '',
        success: false,
    })
    return (

            <>
                <hr />
                <div>
                    Product Created:
                    <div>{product.name}</div>
                    <div>{product.price}</div>
                    <div>{product.quantityInStock}</div>
                    <div>{product.portionSize}</div>
                    <div>{product.flavor}</div>
                    <div>{product.description}</div>
                </div>
            </>

    );
}
export default OpenProductPage