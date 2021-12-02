import React from "react";
import classes from "./styles.module.css"

const Search = (props) => {
    const {keywords, actionOnChange, ...action} = props;
    return(
        <div>
            <form>
            <input
                className={classes.textField}
                type="text"
                placeholder="Search item"
                name="keywords"
                value={keywords}
                onChange={actionOnChange}
                {...action}
            >
            </input>
            </form>
        </div>
    );
}

export default Search;