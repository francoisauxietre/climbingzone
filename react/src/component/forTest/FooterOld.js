import React from 'react'
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
let a =1;

class FooterOld extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {

        return <li>{a}</li>
    }
}
export default FooterOld