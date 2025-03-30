import { useNavigate } from "react-router-dom";
import "./Sidebar.css";
import NavItem from "./NavItem";
import {
  faHouse,
  faClipboardQuestion,
  faBookmark
} from "@fortawesome/free-solid-svg-icons";






const Sidebar = () => {
  const navi = useNavigate
  return (
    <>
      <div className="side-navbar">
        <ul className="nav-item-container">
          <NavItem onClick={() => navi("/")} icon={faHouse} size={"l"}>
            Home
          </NavItem>
          <NavItem onClick={() => navi("/questions")} icon={faClipboardQuestion} size={"lg"}>
            Questions
          </NavItem>
          <NavItem onClick={() => navi("/saves")} icon={faBookmark} size={"lg"}>Saves</NavItem>
        </ul>
      </div>
    </>
  );
};

export default Sidebar;