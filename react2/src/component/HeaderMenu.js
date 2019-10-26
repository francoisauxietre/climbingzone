import React, {Component} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import GetClimber from "../request/GetClimber";


class HeaderMenu extends Component {
    constructor(props) {
        super(props);
        this.setState={
            climbers:[]
        }

    }


    getClimbers (){
        console.log("getClimbers")
        return <GetClimber/>
    }

    render() {

        const classes = makeStyles(theme => ({
            button: {
                margin: theme.spacing(1),
            },
            input: {
                display: 'none',
            },
        }));


        return (
            <div>
                {/*<Button variant="contained" color="secondary" className={classes.button} onClick={(e) => {*/}
                {/*    clicked("toto");*/}
                {/*}}>*/}
                <Button variant="contained" color="secondary" className={classes.button}>
                    Cards
                </Button> {/*    Climbers*/}
                {/*</Button>*/}
                <Button variant="contained" color="secondary" className={classes.button} onClick={this.getClimbers
                }>
                    Climbers
                </Button>

                <Button variant="contained" color="secondary" className={classes.button}>
                    Cards
                </Button>
                <Button variant="contained" color="secondary" className={classes.button}>
                    PLace
                </Button>
                <Button variant="contained" href="#contained-buttons" className={classes.button}>
                    Link
                </Button>
                <input
                    accept="image/*"
                    className={classes.input}
                    id="contained-button-file"
                    multiple
                    type="file"
                />
                <label htmlFor="contained-button-file">
                    <Button variant="contained" component="span" className={classes.button}>
                        Upload
                    </Button>
                </label>

            </div>
        );

    }


}

export default HeaderMenu;