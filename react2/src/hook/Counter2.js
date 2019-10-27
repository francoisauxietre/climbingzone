import React, {useState} from "react";

function Counter2() {
    //cree la valeur et une methode
    const initial = 0
    const [count, setCount] = useState(initial)
    const incrementFive = ()=>{
        for (let i=0; i<5; i++){setCount(prev=> prev+1)}
    }

    return (
        <div>
            {count}
            <h2>
                {/*<button onClick={() => setCount(count+1)}>count {count}</button>*/}
                <button onClick={() => setCount(count + 1)}>+</button>
                <button onClick={() => setCount(count - 1)}>-</button>
                <button onClick={() => setCount(initial)}>Reset</button>
                <button onClick={incrementFive}>+5</button>
            </h2>
        </div>
    )

}

export default Counter2;