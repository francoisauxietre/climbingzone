import React from 'react';


class MainHeader extends React.Component {

    render() {
        return (
            <header className={this.props.class}>
                <div>
                    <button onClick={(e) => {
                        // this.addName()
                    }}>Climber Name
                    </button>

                    <input ref="climberNameBox" type="text"/>

                    <button onClick={(e) => {
                        // this.addRoute()

                    }}>Climber Route
                    </button>
                    <input ref="climberRouteBox" type="text"/>
                    <button onClick={(e) => {
                        // this.addPlace()

                    }}>Climber Place
                    </button>
                    <input ref="climberPlaceBox" type="text"/>

                </div>
            </header>
        );
    }
}


export default MainHeader;
