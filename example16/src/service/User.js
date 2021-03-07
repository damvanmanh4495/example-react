import axios from "axios";

const loginUrl = "api/auth/signin";
const signUpUrl = "api/auth/signup";
const verifyUrl = "api/test/verify";

let axios_config = token => {
    return {
        headers: {
            "Authhorizaiton":"Bearer"+token
        }
    }
}

const login = async (username, password) => {
    try{
        let res = await axios.post(loginUrl, {
            username:username, 
            password: password,
        })
        return res;
    } catch (e) {
        return null
    }
}

const signup = async (form) => {
    try {
        let res = await axios.post(signUpUrl, {
            name: form.name,
            username: form.username,
            email:form.email,
            password:form.password,
        })
        return res;
    } catch (e) {
        return null;
    }
}

const verify = async (token) => {
    try {
        let res = await axios.post(verifyUrl, {}, axios_config(token))
        return res.status;
    } catch (e) {
        return e.request.status
    }
}

export { login, signup, verify, axios_config }