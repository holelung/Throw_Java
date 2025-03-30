import { LeafIcon } from "../../Icons/LeafIcon";
import { styled } from "styled-components";

import './Header.css';
import BasicButton from "../../modules/Button/BasicButton";

const StyledTitle = styled.p`
  font-size:32px;
  text-align:center;
  padding: 5px 7px;
  margin: 3px 5px;
  
`;



const Header = () => {
  return (
    <>
      <header className="h-16 px-4">
        <div className="header-container">
          <div className="logo-section flex flex-row items-center ">
            <LeafIcon size={"3x"}></LeafIcon>
            <StyledTitle>ThrowJava</StyledTitle>
          </div>
          <div className="search-section">
            <input
              className="search-input"
              type="text"
              placeholder="Search.."
            />
            <svg
              id="searchIcon"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              fill="currentColor"
              className="size-6"
              aria-hidden="true"
            >
              <path
                fillRule="evenodd"
                d="M10.5 3.75a6.75 6.75 0 1 0 0 13.5 6.75 6.75 0 0 0 0-13.5ZM2.25 10.5a8.25 8.25 0 1 1 14.59 5.28l4.69 4.69a.75.75 0 1 1-1.06 1.06l-4.69-4.69A8.25 8.25 0 0 1 2.25 10.5Z"
                clipRule="evenodd"
              />
            </svg>
          </div>
          <div className="user-buttons ">
            <div className="before-sign-in">
              <BasicButton >sign-in</BasicButton>
              <BasicButton color={"#336dff"}>sign Up</BasicButton>
            </div>
            <div className="after-sign-in section-none"></div>
          </div>
        </div>
      </header>
    </>
  );
};

export default Header;
