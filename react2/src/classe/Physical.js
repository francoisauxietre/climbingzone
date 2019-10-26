import React from 'react';

function Physical({physical}) {
    return (
        <option value={physical.grade}>{physical.grade}</option>)
}

export default Physical;