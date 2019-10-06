import React from 'react'
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Request from "superagent";
import _ from "lodash";

const useStyles = makeStyles(theme => ({
    button: {
        margin: theme.spacing(1),
    },
    input: {
        display: 'none',
    },
}));


const classes = {useStyles};

class Vide extends React.Component {
    state = {message: ""}

    constructor(props) {
        super();
        this.state = {
            text: "Submit",
            name: "",
            climbs: [1,2],
            enumText: "es"
        }
    }

// avant que le component soit monter
    UNSAFE_componentWillMount() {
        this.search()
    }

// apres que le component soit effacer
    UNSAFE_componentWillUnmount() {
    }

    // a la receptikon de nouvelle valeurs props
    UNSAFE_componentWillReceiveProps(nextProps, nextContext) {
        console.log(this.state.text)
    }

    // a l'update du composant
    UNSAFE_componentWillUpdate(nextProps, nextState, nextContext) {
    }


    addClimbers = () => {
// append an array
        const newArr = [1, 2, 3, 4]


// Append a single item
        climbs: this.state.climbs.concat("test")
        console.log(this.state.climbs)
    }

    query() {
        this.search(this.refs.queryBox.value)

    }


    search(param = "User") {

        let url = `http://localhost:8080/api/${param}}`
        Request.get(this.url).then((response) => {
            // this.state.climbers = response.body
        })
        console.log(url)

    }


    clicked(text) {
        this.setState({text: this.refs.te.value})

        console.log({text})
    }

    render() {
        var climbers = _.map(this.state.test, (climber) => {

            return <li>{climber.id}</li>
        })
        return (
            <div>
                <input ref="te" type="text"/>

                {/*<input ref="difficultyBox" type="number"/>*/}


                <Button variant="contained" color="secondary" className={classes.button} onClick={(e) => {
                    this.clicked()
                    this.addClimbers()
                }}>
                    ess
                </Button>

                <div>
                    <input ref="queryBox" type="text" onChange={(event => {
                        this.query()
                    })}/>
                    User Friends Populate
                    <ul>{climbers}</ul>
                    {/*<Climber parentCallback={this.callbackFunction}/>*/}
                    {/*<p> {this.state.message} </p>*/}
                    <Button variant="contained" color="secondary" className={classes.button} onClick={(e) => {
                        this.query("ess")
                    }}>Query
                    </Button>
                    <ul>
                        {this.state.climbs.map(item => (
                            <li key={item}>{item}</li>
                        ))}
                    </ul>
                </div>

            </div>
        )
    }
}

export default Vide;
