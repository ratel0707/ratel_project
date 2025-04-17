import React from "react";

function Post({post}){
    return (
        <div>
            <p>{post.title}</p>
            <p>{post.content}</p>
        </div>
    );
}

export default Post;
