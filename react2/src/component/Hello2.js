import React, {Component} from 'react';
class Hello2 extends Component {

    render() {
    return <div>
        <h1>hello2 :!{this.props.name}</h1>
        <h1>{this.props.children}</h1>
    </div>
    }
}
export default Hello2;