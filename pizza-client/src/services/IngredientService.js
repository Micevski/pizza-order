import axios from '../axios-instance/axios'

const IngredientService = {
    getAllIngredients: () => {
        return axios.get("/ingredients")
    },

    addNewIngredient: (ingredient) => {
        return axios.post("/ingredients", ingredient);
    }
}

export default IngredientService;