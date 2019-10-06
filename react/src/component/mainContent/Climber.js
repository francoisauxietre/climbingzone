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

class Climber extends React.Component {
    constructor(props) {
        super(props);
    }
}
export default Climber