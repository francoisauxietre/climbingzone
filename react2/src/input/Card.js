import React, {Component} from 'react';
import Level from "../classe/Level";
import Physical from "../classe/Physical";
import Technical from "../classe/Technical";
import Tactical from "../classe/Tactical";
import Mental from "../classe/Mental";
import './../css/style1.css'
import './../css/style1.scss'

class Card extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: '',
            message: '',
            level: '4A',
            physical: 0,
            technical: 0,
            tactical: 0,
            mental: 0,
            climberNumber:0,
            climberTotal:0,
            bonus:'',
            climberName:'',
            climbingRouteName:'',
            place:'',
            star:'',
            photo:'',
            qCode:'',
            colorBackCard:'',
            colorFrontCard:''
        }
    }


    changeEmailHandler = (event) => {
        this.setState({email: event.target.value})
    }
    changeMessageHandler = (event) => {
        this.setState({message: event.target.value},
            () => {this.tt()})
    }

    changeLevelHandler = (event) => {
        this.setState({level: event.target.value},
            () => {this.tt()})
    }
    changePhysicalHandler = (event) => {
        this.setState({physical: event.target.value},
            () => {this.tt()})
    }
    changeTechnicalHandler = (event) => {
        this.setState({technical: event.target.value},
            () => {this.tt()})
    }
    changeTacticalHandler = (event) => {
        this.setState({tactical: event.target.value},
            () => {this.tt()})
    }
    changeMentalHandler = (event) => {
        this.setState({mental: event.target.value},
            () => {this.tt()})
    }

    handleSubmit = () => {
        alert(`${this.state.level} -${this.state.physical} -${this.state.technical} -${this.state.tactical} -${this.state.mental}`)

    }

    tt() {
        console.log("" +this.state.level+this.state.physical+this.state.technical+this.state.tactical+this.state.mental)

    }

    render() {
        const levels = [
            {id: 1, level: '4A'},
            {id: 2, level: '4B'},
            {id: 3, level: '4C'},
            {id: 4, level: '5A'},
            {id: 5, level: '5A+'},
            {id: 6, level: '5B'},
            {id: 7, level: '5B+'},
            {id: 8, level: '5C'},
            {id: 9, level: '5C+'},
            {id: 10, level: '6A'},
            {id: 11, level: '6A+'},
            {id: 12, level: '6B'},
            {id: 13, level: '6B+'},
            {id: 14, level: '6C'},
            {id: 15, level: '6C+'},
            {id: 16, level: '7A'},
            {id: 17, level: '7A+'},
            {id: 18, level: '7B'},
            {id: 19, level: '7B+'},
            {id: 20, level: '7C'},
            {id: 21, level: '7C+'},
            {id: 22, level: '8A'},
            {id: 23, level: '8A+'},
            {id: 24, level: '8B'},
            {id: 25, level: '8B+'},
            {id: 26, level: '8C'},
            {id: 27, level: '8C+'},
            {id: 28, level: '9A'},
            {id: 29, level: '9A+'},
            {id: 30, level: '9B'},
            {id: 31, level: '9B+'},
            {id: 32, level: '9C'},
            {id: 33, level: '9C+'}
        ]
        const number = [
            {id: 0, grade: 0},
            {id: 1, grade: 1},
            {id: 2, grade: 2},
            {id: 3, grade: 3},
            {id: 4, grade: 4},
            {id: 5, grade: 5}]

        // const tout = names.map(personne =><Person key = {personne.id} person={personne}/>)
        const level = levels.map(level => <Level key={level.id} level={level}/>)
        const physical = number.map(physical => <Physical key={physical.id} physical={physical}/>)
        const tactical = number.map(tactical => <Tactical key={tactical.id} tactical={tactical}/>)
        const technical = number.map(technical => <Technical key={technical.id} technical={technical}/>)
        const mental = number.map(mental => <Mental key={mental.id} mental={mental}/>)

        return (
            <div className='test'>


            <form onSubmit={this.handleSubmit}>
                <div>
                    <div>
                        <label className={'mailLabel'}>mail:</label>
                        <input className={'mailInput'} type={'text'} value={this.state.email}
                               onChange={this.changeEmailHandler}/>
                    </div>



                    <p></p>
                    <div>
                        <label className={'messageLabel'}>message:</label>
                        <textarea className={'messageInput'} value={this.state.message} rows="5"
                                  onChange={this.changeMessageHandler}></textarea>
                    </div>
                    <p></p>
                    <div>
                        <label className={'levelLabel'}>Level</label>
                        <select className={'levelAreaText'} onChange={this.changeLevelHandler}>
                            {level}
                        </select>

                        <label className={'gardeLabel'}>Physical</label>
                        <select className={'levelAreaText'} onChange={this.changePhysicalHandler}>
                            {physical}
                        </select>

                        <label className={'gardeLabel'}>Technical</label>
                        <select className={'levelAreaText'} onChange={this.changeTechnicalHandler}>
                            {technical}
                        </select>

                        <label className={'gardeLabel'}>Tactical</label>
                        <select className={'levelAreaText'} onChange={this.changeTacticalHandler}>
                            {tactical}
                        </select>

                        <label className={'gardeLabel'}>Mental</label>
                        <select className={'levelAreaText'} onChange={this.changeMentalHandler}>
                            {mental}
                        </select>

                    </div>
                </div>
                <button type="submit">Submit</button>
            </form>
                <h1>visualisation de la carte </h1>
                <div className={'star'}>
                        test
                </div>

            </div>

        );
    }
}


export default Card;
