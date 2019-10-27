import React, {Component} from 'react';
import axios from 'axios'

class PostClimber extends Component {
    constructor(props) {
        super(props);
        this.state = {
            day:'',
            firstName: '',
            lastName: '',
            moth:'',
            year:''
        }
    }


    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    //http://localhost:8080/api/Climber?day=1&firstName=1&lastName=1&month=1&year=1

    submitHandler = e => {

        let urlTest = 'http://localhost:8080/api/Climber?day=' +
            this.state.day+'&firstName=' +
            this.state.firstName+'&lastName=' +
            this.state.lastName+'&month=' +
            this.state.month+'&year=' +
            this.state.year

         e.preventDefault()
        axios.post(urlTest)
            .then(response => {
                console.log(urlTest)
            })
            .catch(error => {
                    console.log(error)
                }
            )
        console.log(this.state)
    }



    render() {

        const {lastName, firstName, day, month, year} = this.state
        return (
            <div>
                <form onSubmit={this.submitHandler}>
                    <div>
                        <label>last Name</label>
                        <input type={'text'} name={'lastName'} value={lastName} onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <label>first Name</label>
                        <input type={'text'} name={'firstName'} value={firstName} onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <label>day</label>
                        <input type={'number'} name={'day'} value={day} onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <label>month</label>
                        <input type={'number'} name={'month'} value={month} onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <label>year</label>
                        <input type={'number'} name={'year'} value={year} onChange={this.changeHandler}/>
                    </div>

                    <button type={'submit'}>Submit</button>
                    <h1>{JSON.stringify(this.state)}</h1>
                </form>
            </div>
        );
    }
}


export default PostClimber;
