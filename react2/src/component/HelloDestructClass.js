import React, {Component} from 'react';

class HelloDestructClass extends Component {


    render() {
        const {firstName, lastName} = this.props
        return <h1>{firstName}{lastName}</h1>
    }

}


export default HelloDestructClass