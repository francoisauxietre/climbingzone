import React from 'react';

//pour passer un composant du fils au pere utiliser => function
function Child (props) {

        return (
            <div>
                <button onClick={props.greethandler}>Great Parent</button>
                <button onClick={() => {props.greethandler('enfant')}}>Great Parent</button>
            </div>
        );

}


export default Child;
