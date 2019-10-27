import React, {useState} from 'react';

function Counter1() {



    //cree la valeur et une methode
   const [count, setCount] = useState(0)


    return (
        <div>
            <button onClick={() => setCount(count+1)}>count {count}</button>
        </div>
    );
}

export default Counter1;