import React from 'react'

class Card extends React.Component{

    handleEvent = event => {
        alert("I was clicked");
    };

    render() {
        return  (
            <div>

            </div>)
    }
}
export default Card;

// function Blog(props) {
//     posts.push({id:4, title:'t', content:'r', test:'r'})
//     const test = props.posts.map((post) =>
//         <div key={post.id}>
//             {post.id}{post.title}{post.content}{post.test}
//         </div>
//     );
//     return (
//         <div>
//             <hr />
//             {test}
//         </div>
//     );
//
//
// }
//
// const posts = [
//     {id: 1, title: 'Hello World', content: 'Welcome to learning React!', test:'e'},
//     {id: 2, title: 'Installation', content: 'You can install React from npm.', test:'4'}
// ];
// ReactDOM.render(
//     <Blog posts={posts} />,
//     document.getElementById('root')
// );