import React from "react";

class Message extends React.Component {


    constructor(props) {
        super(props)
        //un state correspond reellement a une variable interne
        // que l'on change a l'interieur de la classe
        this.state = {

            message: 'wellcome visitor'
        }
    }

    changeMessage() {
        this.setState({
            message: "thanks for suscribing"

        })
    }

    render() {

        console.log(this.props);
        return (
            <div>
                <p>{this.state.message}</p>
                {this.props.name}
                <button onClick={(event) => this.changeMessage()}>Send</button>
            </div>)
    }
}

export default Message