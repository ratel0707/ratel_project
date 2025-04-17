import React from "react";
import { useState, useEffect, useContext} from "react";
import { useNavigate } from "react-router-dom";
import { SignInContext } from "../context/SignInContext";

function RegisterPostPage(){
    const nav = useNavigate();
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [submitBtnPossible, setSubmitBtnPossible] = useState(false);

    const {signInSession, setSignInSession} = useContext(SignInContext);

    const titleHandler = (e)=>{
        setTitle(e.target.value);
        checkSubmitBtnPossible(e.target.value, content);
    };
    
    const contentHandler = (e)=>{
        setContent(e.target.value);
        checkSubmitBtnPossible(title, e.target.value);
    }

    const checkSubmitBtnPossible = (title, content)=>{
        if(title!='' && content!=''){
            setSubmitBtnPossible(true);
        }else{
            setSubmitBtnPossible(false);
        }
    };

    var url = 'http://localhost:8080/post/new';
    if(setSignInSession){
        url = 'http://localhost:8080/post/new/member';
    }

    const submitBtnClickHandler = async (e)=>{
        //e.preventDefault();
        
        //로그인 없이, 그냥 바로 게시글 작성시에 사용되는 익명 공용 memberId = 1
        var memberId = 1;
        if(signInSession!=null){
            memberId = setSignInSession.id;
        }

        try{
            const response = await fetch(url, {
                method: 'POST',
                credentials: 'include',
                headers: {
                    'Content-type': 'application/json',
                },

                body: JSON.stringify({memberId, title, content})
            });


            if(response.ok){
                console.log(response);
                nav('/');
            }else{
                //error
            }
        } catch(error){

        }
    };

    
    return(
        <div>
            <div>
                <h1>Register Post Page</h1>
            </div>

            <div className="title_div">
                <input type="text" placeholder="enter title..." value={title} onChange={(e)=>{titleHandler(e)}}></input>
            </div>

            <div className="content_div">
                <input type="text" placeholder="enter content..." value={content} onChange={(e)=>{contentHandler(e)}}></input>
            </div>

            <button onClick={submitBtnClickHandler} disabled={!submitBtnPossible}>
                submit
            </button>
        </div>
    );
}

export default RegisterPostPage;