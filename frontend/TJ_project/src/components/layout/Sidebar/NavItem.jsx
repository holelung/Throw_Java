import './Sidebar.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


const NavItem = ({ children, onClick, icon, size}) => {
  return (
    <>
      <li className="nav-item">
        <div onClick={onClick}>
          <FontAwesomeIcon icon={icon} size={size} className='nav-icon'/>
          <p className='item-name'>{children}</p>
        </div>
      </li>
    </>
  );
};

export default NavItem;