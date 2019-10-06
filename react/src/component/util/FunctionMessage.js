import * as React from 'react';

const FunctionMessage = (props) => {
    const{name, message} = props
    return (
        <div>
            {name}{" "}{message}
        </div>
    );
};

export default FunctionMessage