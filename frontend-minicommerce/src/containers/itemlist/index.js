import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import Search from "../../components/search";
import Cart from "../../components/cart";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import { Fab } from "@material-ui/core";

class ItemList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [],
      carts:[],
      isLoading: false,
      isCreate: false,
      isSearch: false,
      id: "",
      title: "",
      price: 0,
      description: "",
      category: "",
      quantity: 0,
      isEdit: false,
      keywords:"",
      cartHidden:true,
      buy:0,
    };
    this.handleClickLoading = this.handleClickLoading.bind(this);
    this.handleAddItem = this.handleAddItem.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
    this.handleCheckout = this.handleCheckout.bind(this);
  }

  componentDidMount() {
    this.loadData();
    this.loadDataCart();
  }

  handleAddItem() {
    this.setState({ isCreate: true });
  }

  handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate: false, isEdit: false, isSearch: false });
  }

  handleToggle = () => {
    const cartHidden = this.state.cartHidden;
    this.setState({ cartHidden: !cartHidden });
  };

  async loadData() {
    try {
      const { data } = await APIConfig.get("/item");
      this.setState({ items: data.result });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  async loadDataCart() {
    try {
      const { data } = await APIConfig.get("/cart");
      this.setState({ carts: data.result });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate()");
    return true;
  }

  handleClickLoading() {
    const currentLoading = this.state.isLoading;
    this.setState({ isLoading: !currentLoading });
    console.log(this.state.isLoading);
  }

  handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  }

  async handleSubmitItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity,
      };
      await APIConfig.post("/item", data);
      this.setState({
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0,
      });
      this.loadData();
      this.loadDataCart();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }

  handleEditItem(item) {
    this.setState({
      isEdit: true,
      id: item.id,
      title: item.title,
      price: item.price,
      description: item.description,
      category: item.category,
      quantity: item.quantity,
    });
  }

  async handleSubmitEditItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity,
      };
      await APIConfig.put(`/item/${this.state.id}`, data);
      this.setState({
        id: "",
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0,
      });
      this.loadData();
      this.loadDataCart();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }

  async handleSearchItem (event) {
    event.preventDefault();
    this.setState({isSearch: true})
    try {
        const keywords = event.target.value
        console.log(event.target.value)
        const {data} = await APIConfig.get(`/item?title=${keywords}`)
        this.setState({items: data.result})
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        this.handleCancel(event);
    }
}

async handleCheckout (event) {
  event.preventDefault();
  try {
      await APIConfig.get(`/cart/checkout`)
      this.setState({carts: []})
      this.loadData()
      this.loadDataCart()
  } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
      this.handleCancel(event);
  }
}

async handleAddItemToCart(event, item) {
  event.preventDefault();
  try {
    const targetInd = this.state.carts.findIndex(
      (it) => it.item.id === item.id
    );
    if (targetInd < 0) {
      if (parseInt(this.state.buy) > parseInt(item.quantity)) {
        alert("Stok tidak memenuhi!");
      } else {
        const data = {
          idItem: item.id,
          quantity: this.state.buy,}
        await APIConfig.post(`/cart`, data);
        this.setState({
          buy: 0,
        });
        this.loadData();
        this.loadDataCart();
      }
    } else {
      if (
        parseInt(this.state.buy) +
          parseInt(this.state.carts[targetInd].quantity) >
        parseInt(item.quantity)
      ) {
        alert("Stok tidak memenuhi!");
      } else {
        const data = {
          idItem: item.id,
          quantity: this.state.buy,
        };
        await APIConfig.post(`/cart`, data);
        this.setState({
          buy: 0,
        });
        this.loadData();
        this.loadDataCart();
      }
    }
  } catch (error) {
    alert("Oops terjadi masalah pada server");
    console.log(error);
  }
}

  render() {
    console.log("render()");

    return (
      <div className={classes.itemList}>
        <h1 className={classes.title}>{this.state.cartHidden ? "All Items" : "Cart Items"}</h1>
        {this.state.cartHidden ? <> <div style={{ position: "fixed", top: 25, right: 25 }}>
          <Fab variant="extended" onClick={this.handleToggle}>
              <Badge
                color="secondary"
                badgeContent={this.state.carts.length}
              >
                <ShoppingCartIcon />
              </Badge>
          </Fab>
        </div>
        <div>
        <Search keywords={this.state.keywords} onChange={this.handleChangeField} onKeyPress={event => {
                        if (event.key === 'Enter') {this.handleSearchItem(event)}
                    }}></Search>
        <Button action={this.handleAddItem}>Add Item</Button>

        {this.state.items.map((item) => (
            <Item
              key={item.id}
              id={item.id}
              title={item.title}
              price={item.price}
              description={item.description}
              category={item.category}
              quantity={item.quantity}
              handleEdit={() => this.handleEditItem(item)}
              handleOnChange={this.handleChangeField}
              handleAddItemToCart={(event) => this.handleAddItemToCart(event,item)}
            />
          ))}
        </div>
        <Modal
          show={this.state.isCreate || this.state.isEdit}
          handleCloseModal={this.handleCancel}
          modalTitle={
            this.state.isCreate ? "Add Item" : `Edit Item ID ${this.state.id}`
          }
        >
          <form>
            <input
              className={classes.textField}
              type="text"
              placeholder="Nama Item"
              name="title"
              value={this.state.title}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="number"
              placeholder="Harga"
              name="price"
              value={this.state.price}
              onChange={this.handleChangeField}
            />
            <textarea
              className={classes.textField}
              placeholder="Deskripsi"
              name="description"
              rows="4"
              value={this.state.description}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="text"
              placeholder="Kategori"
              name="category"
              value={this.state.category}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="number"
              placeholder="qty"
              name="quantity"
              value={this.state.quantity}
              onChange={this.handleChangeField}
            />
            <Button
              action={
                this.state.isCreate
                  ? this.handleSubmitItem
                  : this.handleSubmitEditItem
              }
            >
              Create
            </Button>
            <Button action={this.handleCancel}>Cancel</Button>
          </form>
        </Modal></> : 
        <> 
        <Button action={this.handleToggle}>Back</Button>
        {this.state.carts.length >0 ? <><Button action={this.handleCheckout}>Checkout</Button></> : ``}
        {this.state.carts.map((cart) => (
          <Cart
            key={cart.id}
            id={cart.id}
            quantity={cart.quantity}
            item={cart.item}
          ></Cart>
        ))}</>}
       
      </div>
    );
  }
}
export default ItemList;
