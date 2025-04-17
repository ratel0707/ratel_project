import React from "react";
import { useEffect, useState } from "react";
import Post from "./Post";

function PostList({url}){
    const [posts, setPosts] = useState([]);
    
    useEffect(()=>{
        const fetchData = async()=>{
            console.log({url});
            const res = await fetch(url, {
                method: 'GET',
                credentials: 'include'
            }); //'http://localhost:8080/post/all'
            console.log('res: ' + res);
            const result = await res.json();
            setPosts(result);
            console.log(result);
        }; 
        fetchData();
    }, [url]);

    return (
        <>
            <div>POST LIST component</div>
            <h1>{url}</h1>
            <ul>
                {posts.length !== 0 ? (posts.map((p) => <Post key={p.id} post={p} />)) : (<p>게시글이 없습니다.</p>)}
             </ul>
        </>
    );
}

export default PostList;