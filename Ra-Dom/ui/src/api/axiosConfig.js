import axios from "axios";

const HTTP = axios.create({
    baseUrl:'/api'
    })
export default HTTP;