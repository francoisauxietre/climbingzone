import React from 'react';
import './style1.css'

function Stylesheet(props) {
    let className = props.primary ? 'primary' : ''
    const heading ={
        fontSize :'72px',
        color: 'blue'
    }
    return (
        <div>
            <h1 className={className}>StyleSheet test</h1>
            <h2 style={heading}>Inline </h2>
        </div>
    );
}

export default Stylesheet;