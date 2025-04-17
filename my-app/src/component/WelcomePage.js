import React, { useState } from "react";
import Header from "./Header";
import Content from "./Content"
import SignInButton from "./SigninButton";
import { SignInContext } from "../context/SignInContext";

import { useContext } from "react";
import { useNavigate } from "react-router-dom";

function WelcomePage(){
    //session 정보
    const {signInSession, setSignInSession} = useContext(SignInContext);
    const nav = useNavigate();

    const urlForPostAll = 'http://localhost:8080/post/all';
    const urlForPostMember = 'http://localhost:8080/post/member';
    const [apiUrl, setApiUrl] = useState(urlForPostAll);
    
    //const createUrl = 'http://localhost:8080/post/new'
    //const createUrlMember = 'http://localhost:8080/new/member';
    //const [createPostUrl, setCreatePostUrl] = useState(createUrl);

    const registerBtnClickHandler = ()=>{
        nav('/post/new');
    }
    
    const signOutBtnClickHandler = ()=>{
        setSignInSession(null);
        localStorage.removeItem('signInSession');

        //서버에도 POST요청으로 서버의 세션 정리 요청하기
        const postRequest = async()=>{
            const response = await fetch('http://localhost:8080/member/signOut', {
                credentials: "include",
                method: 'POST',
                headers: {
                    'Content-type': 'application/json',
                }
            });
        };
        postRequest();
    }

    
    const myPostBtnClickHandler = ()=>{
       setApiUrl(urlForPostMember);
       console.log(apiUrl);
    }

    return (
        <>
          <Header></Header>
          <div>
            <Content url={apiUrl}></Content>
            
            {signInSession==null && (<SignInButton></SignInButton>)}
            
            {signInSession && (<button className="signOut_Btn" onClick={signOutBtnClickHandler}>sign out</button>)}

            <br></br>
            <p>test for post register</p>
            <button onClick={registerBtnClickHandler}>register post</button>
            
            {signInSession && (<div>
                <br></br>
                <button className="member_post" onClick={myPostBtnClickHandler}>my post</button>
            </div>)}


            {signInSession && (<div>
                <h3>회원 정보</h3>
                <p>닉네임: {signInSession.nickname}</p>
                <p>이메일: {signInSession.email}</p>
                <p>권한: {signInSession.role}</p>
            </div>)}
          </div>
        </>
    );

}

export default WelcomePage;