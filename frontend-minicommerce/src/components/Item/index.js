import React from "react";
import classes from "./styles.module.css";
import Button from "../button";

const Item = (props) => {
  const {
    id,
    title,
    price,
    description,
    category,
    handleEdit,
    quantity,
    handleDelete,
    handleOnChange,
    handleAddItemToCart
  } = props;
  return (
    <div className={classes.item}>
      <h3>{`ID ${id}`}</h3>
      <p>{`Nama Barang: ${title}`}</p>
      <p>{`Price: ${price}`}</p>
      <p>{`Description: ${description}`}</p>
      <p>{`Category: ${category}`}</p>
      <p>{`Stok: ${quantity}`}</p>
      <Button action={handleEdit}>Edit</Button><br></br>
      <input name="buy" type="number" onChange={handleOnChange}/>
      <Button action={handleAddItemToCart}>Add to Cart</Button>
    </div>
  );
};
export default Item;