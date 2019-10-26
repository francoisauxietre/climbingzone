import React, {Component} from 'react';
import Child from "./Child";

class Parent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            parentName: 'parent'
        }
        this.greetParent= this.greetParent.bind(this)
    }

    greetParent(childName) {
        // alert('hello', this.state.parentName)  autre notation
        alert(`Hello ${this.state.parentName} depuis  ${childName}`)
    }

    render() {
        return (
            <div>
                <h1>{this.state.parentName}</h1>
                <Child greethandler={ this.greetParent}/>
            </div>
        );
    }
}

export default Parent;
