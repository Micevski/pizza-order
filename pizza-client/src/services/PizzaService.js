import axios from '../axios-instance/axios'

const PizzaService = {
    getAllPizzas: () => {
      return axios.get("/pizzas")
    }
}

export default PizzaService;