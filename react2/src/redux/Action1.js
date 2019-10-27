import { createStore } from 'redux'

const store = createStore(reducer, ['Use Redux'])
const store1 = createStore(todos, ['Use Redux'])

const BUY_CAKE = 'BUY_CAKE'

function buyCake (){
// action
    return {
        type: BUY_CAKE,
        info: 'first action on redux'
    }
}



const initialState = { numOfCake:10}

//reducer
const reducer = (state = initialState, action)=>{
    switch (action.type) {
        case  BUY_CAKE: return{
            ...state, numOfCake: state.numOfCake -1
        }
        default: return state
    }
}


function todos(state = [], action) {
    switch (action.type) {
        case 'ADD_TODO':
            return state.concat([action.text])
        default:
            return state
    }
}

console.log('store ', store.getState())
console.log('store1 ', store1.getState())

const unsubscribe = store.subscribe(()=> console.log('update', store.getState()))
const unsubscribe1 =store1.subscribe(()=> console.log('update', store.getState()))
store.dispatch(buyCake())
store.dispatch(buyCake())

store1.dispatch({
    type: 'ADD_TODO',
    text: 'Read the docs'
})

unsubscribe()
unsubscribe1()
