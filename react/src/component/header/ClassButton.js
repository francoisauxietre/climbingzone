import React from "react";

class ClassButton extends React.Component {
    // constructor(props) {
    //     super(props);
    // }

    render() {
        console.log(this.props);
        return (
            <div>
                {this.props.name}
            </div>)
    }
}
export default ClassButton