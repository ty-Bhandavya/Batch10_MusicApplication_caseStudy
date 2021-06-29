import { BrowserRouter, Route, Switch } from "react-router-dom";
import AddMusic from "./components/AddMusic.js";
import Home from "./components/Home.js";
import ShowMusic from "./components/ShowMusic";
import { routing } from "./routers/routing.js";
function App() {
  return (
    <BrowserRouter>
      {routing}

      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/create" component={AddMusic} />
        <Route path="/details" component={ShowMusic} />
      </Switch>
    </BrowserRouter>
  );
}
export default App;