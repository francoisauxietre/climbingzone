import React from 'react';

function Technical({technical}) {
    return (
        <option value={technical.grade}>{technical.grade}</option>)
}

export default Technical;