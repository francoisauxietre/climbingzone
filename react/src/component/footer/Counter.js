import React, {Component} from 'react';

/**
 *  pass addValue 1 to add 1 and name={"nameOfTheButton"}
 *  pass addValue 5 to add 5 and name={"nameOfTheButton"}
 */
class Counter extends Component {

    constructor(props) {
        super(props);
        this.state = {
            count: 0
        }
    }

//     ajout d'un call back pour etre sur que dans la console on est bien la meme valeur
//     que ici
//     si on veut changer les setstate bien faire le callback

    increment() {
        this.setState({
            count: this.state.count + 1
        }, () => {
            console.log('callback value', this.state.count)
        })
        // console.log(this.state.count )
    }

    incrementBis() {
        this.setState((previousState, props) => ({
                count: previousState.count + props.addValue
            }), () => {
                console.log(this.state.count)
            })
    }


    render() {
        return (
            <div>
                count : {this.state.count}
                <button onClick={() => {
                    this.incrementBis()
                }}>{this.props.name}
                </button>
            </div>
        );
    }

}

// Counter.propTypes = {};

export default Counter;
