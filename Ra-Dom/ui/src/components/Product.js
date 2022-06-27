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
                <label htmlFor="name">Name:</label>
                <input
                    value={product.name}
                    type="text"
                    onChange={handleChange}
                    name="name"
                /><br/>
                <label htmlFor="price">Quantity:</label>
                <input
                    value={product.price}
                    type="number"
                    onChange={handleChange}
                    name="price"
                /><br/>
                <label htmlFor="amount">Price:</label>
                <input
                    value={product.amount}
                    type="number"
                    onChange={handleChange}
                    name="amount"
                /><br/>
                <label htmlFor="description">Description:</label>
                <input
                    value={product.description}
                    type="text"
                    onChange={handleChange}
                    name="description"
                /><br/>

                <button type="submit">Submit</button>
            </form>
        </>
    );
}
export default ExampleForProduct;
