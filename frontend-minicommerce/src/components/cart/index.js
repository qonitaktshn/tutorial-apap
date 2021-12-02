import React from "react";
import classes from "./styles.module.css";
import Button from "../button";

const Cart = (props) => {
  const {
    id,
    quantity,
    item,
  } = props;
  return (
    <div className={classes.cart}>
      <h3>{`ID ${id}`}</h3>
      <p>{`Nama Barang: ${item.title}`}</p>
      <p>{`Price: ${item.price}`}</p>
      <p>{`Jumlah: ${quantity}`}</p>
      <p>{`Description: ${item.description}`}</p>
      <p>{`Category: ${item.category}`}</p>
      <p>{`Total Harga: ${quantity*(item.price)}`}</p>
    </div>
  );
};
export default Cart;
