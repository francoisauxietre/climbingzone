import React from 'react'

class HeaderRight extends React.Component{

    handleEvent = event => {
        alert("I was clicked");
    };

    render() {
        return  (
            <table>
                <tbody>
                <tr className="left">
                    <td>droite</td>
                </tr>
                </tbody>
            </table>
        )
    }
}
export default HeaderRight;