import { useNavigate } from "react-router-dom";

const Footer = () => {
  const navi = useNavigate();
  return (
    <>
      <footer className="py-3 bg-gray-900 text-gray-300">
        <ul className="flex justify-center py-3 my-3">
          <li className="footer-item">
            <div
              onClick={() => navi("/")}
              className="nav-link px-2 text-body-secondary"
            >
              Home
            </div>
          </li>
          <li className="footer-item">
            <a href="#" class="nav-link px-2 text-body-secondary">
              Questions
            </a>
          </li>
          <li className="footer-item">
            <a href="#" class="nav-link px-2 text-body-secondary">
              Help
            </a>
          </li>
          <li className="footer-item">
            <a href="#" class="nav-link px-2 text-body-secondary">
              FAQs
            </a>
          </li>
          <li className="footer-item">
            <a href="#" class="nav-link px-2 text-body-secondary">
              About
            </a>
          </li>
        </ul>
        <p className="text-center py-3 text-m ">© 2024 ThrowJava, Inc</p>
      </footer>
    </>
  );
};

export default Footer;
