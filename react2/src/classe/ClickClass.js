import React, {Component} from 'react';

class ClickClass extends Component {
    clickHandler(){
        console.log('cliecker class')
    };
    render() {
        return (
            <div>
                <button onClick={this.clickHandler}>Click Class</button>
            </div>
        );
    }
}


export default ClickClass;
