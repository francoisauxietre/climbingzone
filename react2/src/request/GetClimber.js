import React, {Component} from 'react';
import axios from 'axios'

class GetClimber extends Component {
    constructor(props) {
        super(props);
        this.state = {
            climbers: [],
            error: ''
        }
    }


    componentDidMount() {
        axios.get('http://localhost:8080/api/Climber')
            .then(response => {
                console.log(response)
                this.setState({climbers: response.data})
            })
            .catch(error => {
                    console.log(error)
                    this.setState({error: "error vith url "})
                }
            )
    }

    errorHandler = () => {
        alert(`${this.state.error}`)
    }


    render() {
        const {climbers} = this.state
        return (
            <div>
                <h2> TEST</h2>
                {
                    climbers.length ?
                        climbers.map(climber =>
                            <div key={climber.idClimber}> {climber.lastName} {climber.firstName}
                            </div>) :
                        null
                }
                {this.state.error ? this.errorHandler() : null}
            </div>)
    }
}

export default GetClimber
