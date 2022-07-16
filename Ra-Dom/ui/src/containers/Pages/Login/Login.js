import './statics/loginStyle.css'
import {useState} from "react";

const Login = () => {

    const [login, setLogin] = useState({
        email: '',
        password: ''
    })

    const onSubmit = (e) => {
        e.preventDefault()

        console.log("login", login)
    }

    const onChange = (e) => {
        setLogin({
            email: e.target.value,
            password: e.target.value
        })
    }

    return (
        <div className="Auth-form-container">
            <form className="Auth-form" onSubmit={onSubmit}>
                <div className="Auth-form-content">
                    <h3 className="Auth-form-title">Sign In</h3>
                    <div className="form-group mt-3">
                        <label>Email address</label>
                        <input type="email"
                               className="form-control mt-1"
                               placeholder="Enter email"
                               value={login.email}
                               onChange={onChange}
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>Password</label>
                        <input type="password"
                               className="form-control mt-1"
                               placeholder="Enter password"
                               value={login.email}
                               onChange={onChange}
                        />
                    </div>
                    <div className="d-grid gap-2 mt-3">
                        <button type="submit" className="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </div>
            </form>
        </div>
    )
}

export default Login



