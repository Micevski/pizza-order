import React from "react";
import IngredientItem from "../ingredient-item/ingredientItem";
import {Link} from "react-router-dom";

const Ingredients = (props) => {

    let allingredients = props.ingredients;
    const ingredients = allingredients.map((it, i) => {
        return <IngredientItem ingredient={it}
                               key={i}/>
    });


    return (
        <div className="row">
            <h4 className="text-upper text-left">Ingredients</h4>
            <div className="table-responsive">
                <table className="table tr-history table-striped small">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Spicy</th>
                        <th scope="col">Veggie</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {ingredients}
                    </tbody>
                </table>
            </div>
            <Link to={"add-ingredient"}>
                <button className="btn btn-outline-secondary">
                    <span><strong>Add new ingredient</strong></span>
                </button>
            </Link>
        </div>
    )
}

export default Ingredients;