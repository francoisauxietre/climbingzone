import React, {useState} from 'react'
import Button from "@material-ui/core/Button";
import {makeStyles} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    button: {
        margin: theme.spacing(1),
    },
    input: {
        display: 'none',
    },
}));

const classes = {useStyles};

function Route(props) {

    let climberName = props.climberName;
    let route = props.route;
    let place = props.place;

    //
    //
    // let name = props.children[0];
    // let route = props.children[1];
    // let place = props.children[2];

    const [items, setItems] = useState([]);
    const addItem = () => {
        setItems([...items, {
            id: items.length,
            climberName: climberName,
            route: route,
            place: place
        }])
    };

    function removeItem(index) {
        // this.setState({
        //     data: this.state.data.filter((_, i) => i !== index)
        // });
    }

    console.log("Route.js:  " + props.children)
    return (
        <div>

            <ul>
                {items.map(item => (
                    <li key={item.id}>{" Climber : "} {item.climberName}{" Route : "}{item.route}{" Place : "}{item.place}</li>))}
                {/*<button onClick={() => setCount(count + 1)}>Count {count}</button>*/}
            </ul>
            {/*<button onClick={addItem}>add a climber</button>*/}
            <Button variant="contained" color="primary" className={classes.button} onClick={addItem}>
                Add a New Climber
            </Button>
            <Button variant="contained" color="secondary" className={classes.button} onClick={removeItem(1)}>
                Delete a Climber
            </Button>
        </div>
    )
}

export default Route
