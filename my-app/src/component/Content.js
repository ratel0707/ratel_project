import PostList from "./PostList";
import SignInButton from "./SigninButton";

function Content({url}){
    return (
       <div>
            <h1>Content component</h1>
            <h2>{url}</h2>
            <div>
                <PostList url = {url}></PostList>
            </div>
       </div>
    );
}

export default Content;