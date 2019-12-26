import React from "react";

const IngredientItem = (props) => {

    const ingredient = props.ingredient;
    return (
        <tr>
            <td scope="col">{ingredient.name}</td>
            <td scope="col">{ingredient.amount}</td>
            <td scope="col">{ingredient.spicy.toString()}</td>
            <td scope="col">{ingredient.veggie.toString()}</td>
            <td scope="col">
                <button className="btn btn-sm btn-secondary">
                    <span className="fa fa-edit"/>
                    <span><strong>Edit</strong></span>
                </button>
                <button className="btn btn-sm btn-outline-secondary ">
                    <span className="fa fa-remove"/>
                    <span><strong>Remove</strong></span>
                </button>
                <button className="btn btn-sm btn-outline-dark">
                    <span><strong>Details</strong></span>
                </button>
            </td>
        </tr>
    )

}
export default IngredientItem