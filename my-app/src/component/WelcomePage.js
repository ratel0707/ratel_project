import React from "react";
import Header from "./Header";
import Content from "./Content"
import SignInButton from "./SigninButton";

import { useNavigate } from "react-router-dom";

function WelcomePage(){
    const nav = useNavigate();

    const registerBtnClickHandler = ()=>{
        nav('/post/new');
    }
    
    return (
        <>
          <Header></Header>
          <div>
            <Content></Content>
            <SignInButton></SignInButton>

            <br></br>
            <p>test for post register</p>
            <button onClick={registerBtnClickHandler}>register post</button>
          </div>
        </>
    );

}

export default WelcomePage;