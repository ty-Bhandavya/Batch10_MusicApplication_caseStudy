import {Link, Route, Switch} from 'react-router-dom';
import Home from '../Component/Home';
import Login from '../Component/Login';
import ShowAccount from '../Component/ShowAccount';


export const music = (
  <>
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/home">
         Music World
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link active" aria-current="page" to="/login">
               Create Account
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/showaccount">
                Show Account
              </Link>
            </li> 
          </ul>
        </div>
      </div>
    </nav>
    <Switch>
      <Route path="/home" component={Home} />
      <Route path="/login" component={Login} />  
      <Route path="/showaccount" component={ShowAccount} />  
    </Switch> 
  </>
);
