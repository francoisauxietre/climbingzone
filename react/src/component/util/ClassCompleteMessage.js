import React from 'react';


class ClassCompleteMessage extends React.Component {

    constructor({message, date, info, climberName, topic}) {
        super();
        this.state ={

            message:message,
            date:date,
            info:info,
            climber:climberName,
            topic:topic
        }

    }


    render() {
        // ou ceci
         const {messageP, dateP, infoP, climberNameP, topicP} = this.props
         const {messageS, dateS, infoS, climberNameS, topicS} = this.state
        return (
            <div>
                props:{messageP}{dateP}{infoP}{climberNameP}{topicP}{messageP}
                state:{messageS}{dateS}{infoS}{climberNameS}{topicS}{messageS}
            </div>
        );
    }
}


export default ClassCompleteMessage;
