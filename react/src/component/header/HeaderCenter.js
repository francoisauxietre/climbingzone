import React from 'react'
import logo from '../../picture/logo.svg'
import TableCell from '@material-ui/core/TableCell';
import {makeStyles} from '@material-ui/core/styles';
import HeaderMenu from "./HeaderMenu";

const useStyles = makeStyles(theme => ({
    root: {
        width: '120%',
        marginTop: theme.spacing(3),
        overflowX: 'auto',
    },
    table: {
        minWidth: 650,
    },
}));

class HeaderCenter extends React.Component{

    render() {
        return  (
            <div>
            <div>
                <div>
                    <div>
                        <TableCell align="left"><img src={logo} className="App-logo" alt="climbing Zone logo"/></TableCell>
                        <TableCell align="center"> <HeaderMenu/></TableCell>
                    </div>
                </div>
            </div>
            </div>

        )
    }
}
export default HeaderCenter;