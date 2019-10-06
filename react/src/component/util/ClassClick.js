import React, {Component} from 'react';



class ClassClick extends Component {

    clickHandler() {
console.log("ClassClick" )
    }
    render() {

        return (
            <div className={"ClassClick"}>
                {/*ici on a bien une fonction qu l'on appelle*/}
                <button onClick={this.clickHandler}>ClassClick</button>

            </div>
        );
    }


}


export default ClassClick;
