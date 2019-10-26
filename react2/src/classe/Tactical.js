import React from 'react';

function Tactical({tactical}) {
    return (
        <option value={tactical.grade}>{tactical.grade}</option>)
}

export default Tactical;