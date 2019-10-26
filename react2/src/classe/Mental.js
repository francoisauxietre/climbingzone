import React from 'react';

function Mental({mental}) {
    return (
        <option value={mental.grade}>{mental.grade}</option>)
}

export default Mental;