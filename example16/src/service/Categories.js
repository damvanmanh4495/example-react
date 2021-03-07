import axios from "axios";
import { axios_config } from "./User";

const categoriesUrl = "admin/categories";

const getListCategories = async (page, pageSize) => {

    let params = {
        page: page ? page : 1,
        size: pageSize ? pageSize : 5
    };

    let config = {
        params: params
    }

    let rsp = await axios.get(categoriesUrl, config);
    return rsp.data;
}

const getCategoryById = async (id) => {
    let url = categoriesUrl + "/" + id;
    let rsp = await axios.get(url);
    return rsp.data;
}

const createCategory = (token, form) => {
    let res = axios.post(categoriesUrl, {
        name: form.name,
        code: form.code,
        descriptions: form.descriptions,
    }, axios_config(token))
    return res;
}

const updateCateogry = (token, form, id) => {
    const url = categoriesUrl + "/" + id;
    let res = axios.put(url, {
        name: form.name,
        code: form.code,
        descriptions: form.descriptions
    }, axios_config(token))
    return res;
}

const deleteCategory = (toekn, id) => {
    let url = categoriesUrl + "/" + id;
    let res = axios.delete(url, axios_config(toekn));
    return res;
}

export { getListCategories, createCategory, getCategoryById, updateCateogry, deleteCategory}