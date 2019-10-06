import React from 'react';
import HeaderCenter from "./HeaderCenter";

class MainHeader extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            <header className={this.props.class}>
                <HeaderCenter/>
                <div>
                    <button onClick={(e) => {
                        this.addName()
                    }}>Climber Name
                    </button>

                    <input ref="climberNameBox" type="text"/>

                    <button onClick={(e) => {
                        this.addRoute()

                    }}>Climber Route
                    </button>
                    <input ref="climberRouteBox" type="text"/>
                    <button onClick={(e) => {
                        this.addPlace()

                    }}>Climber Place
                    </button>
                    <input ref="climberPlaceBox" type="text"/>

                </div>
            </header>
        );
    }
}


export default MainHeader;
