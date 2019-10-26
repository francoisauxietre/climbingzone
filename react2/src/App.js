import React, {Component} from 'react';
// import logo from './logo.svg';
import './App.css';
import Hello from './component/Hello'
import Hello1 from './component/Hello1'
import Hello2 from "./component/Hello2";
import Message from "./component/message";
import Counter from "./component/Counter";
import HelloDestruct from "./component/HelloDestruct";
import FunctionClick from "./function/functionClick";
import ClickClass from "./classe/ClickClass";
import EventBind from "./classe/EventBind";
import Parent from "./parent/Parent";
import List from "./classe/List";
import Card from "./input/Card";

import Stylesheet from "./css/Stylesheet";
// import "./css/AppStyles.css" // le css va dans tous les fils pas dans le cas d'un module
// import styles from "./css/AppStyles.module.css"
import ControlComponentInputText from "./input/ControlComponentInputText";
import MainHeader from "./component/MainHeader";
import HeaderCenter from "./component/HeaderCenter";
import HeaderMenu from "./component/HeaderMenu";

class App extends Component {
    render() {
        return (
            <div className={'root'}>
                <div className={'primary'}>
                    <HeaderCenter/>
                    <MainHeader/>
                    <HeaderMenu/>

                    <Card/>
                </div>
                <header>
                    <Stylesheet primary='true'/>

                    {/*<h1 className={'error'}>error</h1><h1 className={styles.succes}>succes</h1>*/}
                    <List/>
                    {/*<img src={logo} className="App-logo" alt="logo"/>*/}
                    <Parent/>
                    <Counter/>
                    <EventBind/>
                    <ClickClass/>
                    <FunctionClick/>
                    <HelloDestruct lastName={"ln_toto"} firstName={"fn_toto"}/>

                    <Hello name="hello test"/>

                    <Hello name="Bruce"/>
                    <Hello name="Bruce"/>
                    <Hello1/>
                    <Hello2 name={"diana"}/>
                    <Message/>
                </header>
            </div>
        );
    }
}

export default App;
