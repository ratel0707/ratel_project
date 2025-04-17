import './App.css';
import Router from './component/Router';
import { useState, useEffect } from 'react';
import { SignInContext } from './context/SignInContext';

function App() {
  //전역적으로 관리한 로그인 세션정보를 context를 사용해서 관리하기
  const [signInSession, setSignInSession] = useState(null);
  useEffect(()=>{
    const stored = localStorage.getItem('signInSession');
    if(stored){
      setSignInSession(JSON.parse(stored));
    }
  }, []);

  return (
    <SignInContext.Provider value={{signInSession, setSignInSession}}>
      <div className="App">
        <Router></Router>
      </div>
    </SignInContext.Provider>
  );
}

export default App;
