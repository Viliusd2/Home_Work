import React, { useState } from 'react';

function ExampleForProduct() {
    // Declare multiple state variables!
    const [product, setProduct] = useState({
        name: '',
        price: '',
        amount: '',
        description: '',
    });

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    function handleSubmit(e) {
        console.log(product);
        e.preventDefault();
    }
    return (
        <>
            <form onSubmit={handleSubmit}>
                <input
                    value={product.name}
                    type="text"
                    onChange={handleChange}
                    name="name"
                />

                <input
                    value={product.price}
                    type="number"
                    onChange={handleChange}
                    name="price"
                />

                <input
                    value={product.amount}
                    type="number"
                    onChange={handleChange}
                    name="amount"
                />

                <input
                    value={product.description}
                    type="text"
                    onChange={handleChange}
                    name="description"
                />

                <button type="submit">Submit</button>
            </form>
        </>
    );
}
export default ExampleForProduct;
