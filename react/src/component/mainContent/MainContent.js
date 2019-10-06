import React, {Component} from 'react';
import Route from "./Route";
import FunctionButton from "../header/FunctionButton";
import ClassButton from "../header/ClassButton";
import Counter from "../footer/Counter";
import Message from "../footer/Message";
import ClassCompleteMessage from "../util/ClassCompleteMessage";
import FunctionMessage from "../util/FunctionMessage";
import FunctionClick from "../util/FunctionClick";
import ClassClick from "../util/ClassClick";
import {Footer} from "../footer/Footer";

class MainContent extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const {className} = this.props;

        return (
        <div className={className}>
            <FunctionButton name={"c1"}><button>click</button><p>test 2</p></FunctionButton>
            <FunctionButton name={"c2"}><p>test 1</p></FunctionButton>
            <ClassButton name={"name "}><p>test class</p></ClassButton>
            <Counter addValue={1} name={"increment +1"}/>
            <Counter addValue={5} name={"increment +5"}/>
            <Message />
            <ClassCompleteMessage message={"test"} date={Date.now()}/>
            <FunctionMessage name={"essai"} message={"voici un test de message passé a props"}/>
            <FunctionClick/>
            <ClassClick/>
        </div>
        );
    }
}


export default MainContent;
