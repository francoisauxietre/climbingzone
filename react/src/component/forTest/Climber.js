import React from 'react'
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Vide from "./Vide";
import Request from 'superagent'
import _ from 'lodash'


const useStyles = makeStyles(theme => ({
    button: {
        margin: theme.spacing(1),
    },
    input: {
        display: 'none',
    },
}));


const classes = {useStyles};

class Climber extends React.Component {
    test = 10;
    test1 = "";

    url;

    constructor(props) {
        super(props);
        this.state = {
            numbers: [],
            climbers: [],
            Route: [],
            Place: []
        }
    }


    UNSAFE_componentWillMount() {
        //http://www.omdbapi.com/?i=tt3896198
        this.url = "http://localhost:8080/api/User"
        // Request.get(this.url).then((response) => {
        //     this.setState({
        //        test: response.body,
        //         climbers:this.state.test
        //
        // //     })
        //        this.setState((state, props) => ({
        //             counter: state.counter + props.increment
        //         }));
        // });
        // fetchComments().then(response => {
        //     this.setState({
        //         comments: response.comments
        //     });
        // Correct

    }

    clicked(text) {
        this.test1++;
        this.test++;
        console.log(this.test, this.test1);
    }

    render() {
        var climbers = _.map(this.state.climbers, (climber) => {

            return <li>{climber.id} {climber.name} {climber.level} {climber.place} </li>
        })
        return (
            <div>
                <input ref="textBox" type="text"/>
                <Button variant="contained" color="secondary" className={classes.button} onClick={(e) => {
                    this.clicked()
                }}>TEST
                </Button>
                {/*<Vide parentCallback={this.callbackFunction}/>*/}
                <p>essai</p>
                <p>{climbers}</p>
                {/*<Vide/>*/}
            </div>
        )
    }
}

export default Climber;
