import React, {Component} from 'react';

class MyComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {

            state1: "test1 ",
            state2: "test2"
        }
    }


    render() {
        const {name, topic} = this.props
        const {state1, state2} = this.state
        return (
            <div>
                ClassMessage: {name}{topic}
                {state1}{state2}
            </div>
        );
    }
}


export default MyComponent;
