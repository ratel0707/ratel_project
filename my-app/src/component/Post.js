import React from "react";

function Post(props){
    return (
        <div>
            <p>{props.title}</p>
            <p>{props.content}</p>
        </div>
    );
}

export default Post;
