import React from "react";
import { useEffect, useState } from "react";
import Header from "./Header";

function SigninPage(){
    const [submitBtnPossible, setSubmitBtnPossible] = useState(false); 
    const [signInId, setSignId] = useState('');
    const [signInPwd, setSigninPwd] = useState('');

    const checkBtnPossibility = (id, pwd)=>{
        //signinId 와 signinPwd 값을 바로 조건식으로 사용하면, 
        //state 값은 비동기적으로, 렌더링 된 이후 변경된 값이 적용되므로
        //각 handler 함수에서 인자로 받아서(변경되는 것은 e.target.value) 검사해야한다.
        if(id!='' && pwd!=''){
            setSubmitBtnPossible(true);
        }else{
            setSubmitBtnPossible(false);
        }
    }

    const handleSignInValue = (e)=>{
        //console.log(e.target); 실제 이벤트가 발생한 DOM요소
        //console.log(e.currenttarget); 이벤트 리스저가 등록된 요소
        //console.log(e.type); 이벤트 타입(ex, click, change, submit etc)
        //console.log(e.nativeEvent); 브라우저 원래 객체 이벤트
        
        setSignId(e.target.value);
        console.log('log1 : ' + signInId);
        console.log('log2 : ' + e.target.value);
        checkBtnPossibility(e.target.value, signInPwd);
    };

    const handleSignPwdValue = (e)=>{
        setSigninPwd(e.target.value);
        checkBtnPossibility(signInId, e.target.value);
    };

    const url = 'Http://localhost:8080/member/signIn';
    const signinBtnHandler = async ()=>{
        try{
            const response = await fetch(url, {
                method: 'POST',
                headers: {'content-type':'application/json'},

                credentials: 'include',//브라우저가 자동으로 쿠기를 헤더에 첨부해서 요청을 보내게 해줌
                body: JSON.stringify({
                    id : signInId,
                    password: signInPwd
                })
            });

            console.log(response);
            if(response.ok){

            }else{
                //signIn 실패
            }
        } catch(error){}
    }

    return(
        <div>
            <Header></Header>
            <form>
                <label for="id"></label>
                <input type="text" value={signInId} placeholder="enter your id" id="signin_id"
                    onChange={(e)=>handleSignInValue(e)}></input>
                <br></br>
                <label for="pwd"></label>
                <input type="text" value={signInPwd} placeholder="enter your password" id="signin_pwd"
                    onChange={(e)=>handleSignPwdValue(e)}></input>
                <br></br>
                
                <button disabled={!submitBtnPossible} onClick={signinBtnHandler}>SIGN IN</button>
            </form>
        </div>
    );
}

export default SigninPage;