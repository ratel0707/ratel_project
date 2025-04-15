import {BrowserRouter, Routes, Route} from 'react-router-dom'
import WelcomePage from './WelcomePage';
import SigninPage from './SigninPage';
import RegisterPostPage from './RegisterPostPage';

function Router(){
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<WelcomePage></WelcomePage>}></Route>
                <Route path='/signin' element={<SigninPage></SigninPage>}></Route>
                <Route path='/post/new' element={<RegisterPostPage></RegisterPostPage>}></Route>
                <Route path='/'></Route>
            </Routes>
        </BrowserRouter>
    );
}

export default Router;