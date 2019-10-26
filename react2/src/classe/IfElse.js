import React, {Component} from 'react';
import PropTypes from 'prop-types';

class IfElse extends Component {
    constructor(props) {
        super(props);
        this.state ={
            isLoggedIn : true

        }
    }


    render() {
        // let message
        //
        // if(this.state.isLoggedIn){
        //     message = 'fa'}
        //     else message= 'guest'
        return (
            // this.state.isLoggedIn ?
            // <div>wellcome fa</div> :
            //     <div>wellcome fafa</div>
            this.state.isLoggedIn  && <div> hello fa</div>
        );}

}


export default IfElse;
