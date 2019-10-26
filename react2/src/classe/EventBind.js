import React, {Component} from 'react';

class EventBind extends Component {
    constructor(props) {
        super(props);

        this.state = {
            message: 'hello'
        }
        //methode 3
        this.change=  this.change.bind(this)
    }
// methode 1
    change() {
        this.setState({
            message: 'changer'
        })
        console.log(this)
    }

    // methode 4
    change1 = () => {
        this.setState({
            message: 'hello'
        })
        console.log(this)
    }


    render() {
        return (
            <div>
                <h1>{this.state.message}</h1>
                <h2>
                    {/*methode 1*/}
                    {/*<button onClick={this.change.bind(this)}>echange</button>*/}
                    {/*methode 2*/}
                    {/*<button onClick={()=>this.change()}>echange</button>*/}
                    {/*methode 3*/}
                    <button onClick={this.change}>echange</button>
                    <button onClick={this.change1}>echange</button>
                </h2>
            </div>
        );
    }
}


export default EventBind;
