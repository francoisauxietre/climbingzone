import React from 'react'
import logo from '../../picture/logo.svg'
import TableCell from '@material-ui/core/TableCell';
import HeaderMenu from "./HeaderMenu";


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