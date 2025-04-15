import React from "react";
import { useEffect, useState } from "react";
import Post from "./Post";

function PostList(){
    const [posts, setPosts] = useState([]);
    
    useEffect(()=>{
        const fetchData = async()=>{
            const res = await fetch('http://localhost:8080/post/all');
            const result = await res.json();
            setPosts(result);  
        }; 
        fetchData();
    }, []);

    return (
        <>
            <div>POST LIST component</div>
            <ul>
                {posts.map(p => (
                    Post(p)
                    //<li key={p.id}>{p.title}</li>
                ))}
            </ul>
        </>
    );
}

export default PostList;