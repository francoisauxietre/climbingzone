import React from 'react'
import logo from './../picture/logo.svg'
import TableCell from '@material-ui/core/TableCell';


class HeaderCenter extends React.Component {

    render() {
        return (
            <div>
                <div align="left"><img src={logo} className="App-logo" alt="climbing Zone logo"/></div>
            </div>
        )
    }
}

export default HeaderCenter;