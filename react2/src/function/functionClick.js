import React from 'react';

function FunctionClick(props) {
    function clickHandler() {
        console.log("bouton clicker")
    }

    return (
        <div><button onClick={clickHandler}>Click</button></div>
    );
}

export default FunctionClick;