import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles(theme => ({
    button: {
        margin: theme.spacing(1),
    },
    input: {
        display: 'none',
    },
}));

export default function HeaderMenu() {

const classes = useStyles();

    return (
        <div>
            {/*<Button variant="contained" color="secondary" className={classes.button} onClick={(e) => {*/}
            {/*    clicked("toto");*/}
            {/*}}>*/}
                   <Button variant="contained" color="secondary" className={classes.button}>
                Cards
            </Button>     {/*    Climbers*/}
            {/*</Button>*/}
            <Button variant="contained" color="secondary" className={classes.button}>
                Routes
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