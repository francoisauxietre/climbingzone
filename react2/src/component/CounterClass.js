import React, {Component} from 'react';

class CounterClass extends Component{
    constructor() {
        super();
        this.state = {
            count : 0
        }
    }

    add(){
        this.setState({count :this.state.count+1}, ()=> {console.log('callback value', this.state.count)})
    }

    delete(){
        this.setState({count :this.state.count-1}, ()=> {console.log('callback value', this.state.count)})
    }


    render() {
        return(
            <div>
                <h1>
                    {this.state.count}
                </h1>
                <h2><button onClick={()=>this.add()}>Add one </button></h2>
                <h2><button onClick={()=>this.delete()}>remove one </button></h2>
                <p><input type={""}/></p>

            </div>
        )
    }
}
export default CounterClass;