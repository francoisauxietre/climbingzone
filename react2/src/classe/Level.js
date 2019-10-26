import React from 'react';

function Level({level}) {
    return (
        <option value={level.level}>{level.level}</option>)
}

export default Level;