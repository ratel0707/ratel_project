import React from "react";
import { useState, useContext } from "react";
import Header from "./Header";
import { useNavigate } from "react-router-dom";
import { SignInContext } from "../context/SignInContext";

function SigninPage(){
    const [submitBtnPossible, setSubmitBtnPossible] = useState(false); 
    const [signInId, setSignId] = useState('');
    const [signInPwd, setSigninPwd] = useState('');

    const [memberInfo, setMemberInfo]  = useState(null);
    const [signInFail, setSignInFail] = useState(false);

    const nav = useNavigate();
    
    //const signInSession = createContext(null);//로그인 상태를 context를 통해 전역으로 관리
    const {signInSession, setSignInSession} = useContext(SignInContext);

    const checkBtnPossibility = (id, pwd)=>{
        //signinId 와 signinPwd 값을 바로 조건식으로 사용하면, 
        //state 값은 비동기적으로, 렌더링 된 이후 변경된 값이 적용되므로
        //각 handler 함수에서 인자로 받아서(변경되는 것은 e.target.value) 검사해야한다.
        if(id!=='' && pwd!==''){
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

            const data = await response.json();
            //data는 서버에서
            //{data:<>, cnt: <>} 로 온다.
            if(data.data != null){
                setMemberInfo(data.data);
                //성공시 초기화면으로 이동
                //memberInfo도 같이 전달해야함
                //TODO, useContext 학습
                //nav('/', {});
                //setSignInSession(memberInfo);
                setSignInSession(data.data);

                //localStorage에 저장
                localStorage.setItem('signInSession', JSON.stringify(data.data));
                nav('/');
            }else{
                //signIn 실패, 에러요인
                //1) 로그인 정보가 옳지 않던가 
                //2) http 요청에 문제가 있던가
                setMemberInfo(null);
                setSignInFail(true);
            }

            if(response.ok){
                //console.log("good");
            }else{
                //setMemberInfo(null);
                //setSignInFail(true);
                //console.log("bad");
            }
        } catch(error){}
    }

    return(
        <div>
            <Header></Header>
            <div>
                <label for="id"></label>
                <input type="text" value={signInId} placeholder="enter your id" id="signin_id"
                    onChange={(e)=>handleSignInValue(e)}></input>
                <br></br>
                <label for="pwd"></label>
                <input type="text" value={signInPwd} placeholder="enter your password" id="signin_pwd"
                    onChange={(e)=>handleSignPwdValue(e)}></input>
                <br></br>
                
                <button disabled={!submitBtnPossible} onClick={signinBtnHandler}>SIGN IN</button>
            </div>

            <div>
                {memberInfo && (<div>
                    <h3>회원 정보</h3>
                    <p>닉네임: {memberInfo.nickname}</p>
                    <p>이메일: {memberInfo.email}</p>
                    <p>권한: {memberInfo.role}</p>
                </div>)}
            </div>
            
            {signInFail && (
                <div>
                    <p>Fail to signIn... try again</p>
                </div>
            )}
        </div>
    );
}

export default SigninPage;