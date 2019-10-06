import  React from 'react';



const FunctionClick = () => {

    function clickHandler() {
        console.log("clickHandler:" )
    }


    function clickHandlerBis() {
        console.log("clickHandlerBis:" )
        return <p>ess</p>;
    }

    return (
        <div className= "FunctionClick">
            {/*ici on a bien une fonction qu l'on appelle*/}
            <button onClick={clickHandler}>FunctionClick</button>
            {/*ici avec les parenthese on fait un appel (function call*/}
            <button onClick={clickHandlerBis}>FunctionClick Call</button>
        </div>
    );
};

export default FunctionClick