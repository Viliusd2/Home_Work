import React ,{ useState }from "react";
// export default (props) => <h1>Hello, {props.name}!</h1>
export default  (props) =>{
    // Declare a new state variable, which we'll call "count"
    const [count, setCount] = useState(0);

    return (
        <div>
            <p>{count ? count : props.name}</p>
            <button onClick={() => setCount(count + 1)}>Click me</button>
        </div>
    );
}
