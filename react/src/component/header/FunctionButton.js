import React from "react";

const FunctionButton = (props) =>{
    console.log(props)
        return(<div>
            {props.children}
            {props.name}
        </div>)

}

export default FunctionButton