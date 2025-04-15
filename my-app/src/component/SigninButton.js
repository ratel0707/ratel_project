import { useNavigate } from "react-router-dom";

function SignInButton(){
    const nav = useNavigate();

    const btnClickHandler = ()=>{
        nav('/signin');
    }
    
    return (
        <>
            <h1>sigin in button</h1>
            <button className="signin_btn" onClick={btnClickHandler}>Sign In</button> 
        </>
    );
}

export default SignInButton;