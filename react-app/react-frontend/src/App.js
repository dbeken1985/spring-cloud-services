import logo from "./logo.svg";
import "./App.css";
import EmployeeComponent from "./component/EmployeeComponent";

var cors = require("cors");

function App() {
  return (
    <div className="App">
      <EmployeeComponent />
    </div>
  );
}

export default App;
