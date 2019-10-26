import React, {Component} from 'react';

class Message extends Component{
    constructor() {
        super();
        this.state = {
            message : 'Welcome visitor '
        }
    }

    changeMessage(){

        this.setState({message :'test1'})
    }

    render() {
        return(
            <div>
                <h1>
                    {this.state.message}
                </h1>
                <h2><button onClick={()=>this.changeMessage()}>Subscribe </button></h2>
                <p><input type={""}/></p>

            </div>
        )
    }
}
export default Message;