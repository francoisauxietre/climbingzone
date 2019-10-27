import React, {useState} from "react";

function Counter3() {
    //cree la valeur et une methode
    const initial = 0
    const [name, setName] = useState({firstName: '', lastName: ' '})


    return (
        <div>
            <h2>
                <input type={'text'} value={name.firstName} onChange={e => setName({...name, firstName: e.target.value})}/>
                <input type={'text'} value={name.lastName} onChange={e => setName({...name, lastName: e.target.value})}/>
                <h1>first Name:{name.firstName} last Name:{name.lastName}</h1>
                {/*<h1>{JSON.stringify(name)}</h1>*/}

            </h2>
        </div>
    )

}

export default Counter3;