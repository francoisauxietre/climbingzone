import React from 'react';
import Person from "./Person";

function List(props) {
    const names =[{id:1, name: 'ta',
        prenom: 'to',
        age: 7},{id:2, name: 'diana',
        prenom: 'toto',
        age: 27},{id:3, name: 'frre',
        prenom: 'toto',
        age: 42}
    ]


        const tout = names.map(personne =><Person key = {personne.id} person={personne}/>)
        return (
            <div>
                {tout}
            </div>
        );
    }

    export default List;