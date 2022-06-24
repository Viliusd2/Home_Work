import logo from './logo.svg';
import './App.css';
import Example from "./components/MyAwesomeComponent";
import ButtonWithText from "./components/ButtonWithText";
import ProductForm from "./components/ProductV2";
import Product from "./components/Product";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Example name="nepaspaustas"/>
        <ButtonWithText text="Nebuvo paspaustas"/>
        <ProductForm />
        <Product />
      </header>
    </div>
  );
}

export default App;
