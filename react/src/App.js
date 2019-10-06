import React from 'react';
import './App.css';
import 'typeface-roboto';
import MainHeader from "./component/header/MainHeader";




class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            route: "",
            climberName: "",
            place: "",
            showMyComponent: false
        }
    }

    addName() {
        this.setState({climberName: this.refs.climberNameBox.value})
        console.log("app addName" + this.state.climberName)
    }

    addRoute() {
        this.setState({route: this.refs.climberRouteBox.value})
        console.log("app addRoute" + this.state.route)
    }

    addPlace() {
        this.setState({place: this.refs.climberPlaceBox.value})
        console.log("app addPlace" + this.state.place)
    }


    render() {
        return (
            <div className={"app"}>
                {<MainHeader class={"appHeader"}/>}
                {/*{<SideNav className={"appSideNav"}/>}*/}
                {/*{<MainContent/>}*/}
                {/*{<Footer/>}*/}
                {/*<Route climberName={this.state.climberName}*/}
                {/*       route={this.state.route}*/}
                {/*       place={this.state.place}/>*/}
            </div>
        );
    }

}


export default App;
