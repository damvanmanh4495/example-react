import axios from "axios";

const CATEGORIES_BASE_URL = "/admin/categories";

class CategoriesService{
    
    async getAll(){
        return await axios.get(CATEGORIES_BASE_URL);
    }

    async create(category){
        return await axios.post(CATEGORIES_BASE_URL, category);
    }

    async deleteById(id){
        return await axios.delete(CATEGORIES_BASE_URL + "/" + id);
    }

    async getById(id){
        return await axios.get(CATEGORIES_BASE_URL + "/" +id)
    }

    async update(id, category){
        return await axios.put(CATEGORIES_BASE_URL + "/" +id, category)
    }

}

export default new CategoriesService();