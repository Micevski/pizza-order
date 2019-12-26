import React, {Component} from 'react';
import './App.css';
import {BrowserRouter as Router} from 'react-router-dom'
import Header from "./components/header/Header";
import Pizzas from "./components/pizzas/Pizzas";
import {Route} from "react-router";
import PizzaService from "./services/PizzaService";
import Ingredients from "./components/ingredients/Ingredients";
import IngredientService from "./services/IngredientService";
import AddIngredient from "./components/add-new-ingredient/addIngredient";


class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            pizzas: [],
            ingredients: []
        }
    }

    componentDidMount() {
        this.getAllPizzas();
        this.getAllIngredients();
    }

    getAllPizzas = () => {
        PizzaService.getAllPizzas()
            .then((data) => {
                this.setState({
                    pizzas: data.data,
                })
            })
    }

    getAllIngredients = () => {
        IngredientService.getAllIngredients()
            .then((data) => {
                this.setState({
                    ingredients: data.data,
                })
            })
    }

    addNewIngredient = (ingredient) => {
        IngredientService.addNewIngredient(ingredient)
            .then((res) => {
                console.log("Ingredient added", res.data);
                this.setState((prev) => {
                    const newIngredient = [...prev.ingredients, res.data];
                    return {
                        ingredient: newIngredient
                    }
                })
            })
    }


    render() {
        const routing = (
            <Router>
                <Header/>

                <main role="main" className="mt-3">


                    <div className="container">
                        <Route path={"/pizzas"} exact render={() =>
                            <Pizzas pizzas={this.state.pizzas}/>}>
                        </Route>
                        <Route path={"/ingredients"} exact render={() =>
                            <Ingredients ingredients={this.state.ingredients}/>}>
                        </Route>
                        <Route path={"/add-ingredient"} exact render={() =>
                            <AddIngredient addNewIngredient={this.addNewIngredient}/>}>
                        </Route>
                    </div>
                </main>
            </Router>
        )

        return (

            <div className="App">
                {routing}
            </div>
        );
    }
}

export default App;