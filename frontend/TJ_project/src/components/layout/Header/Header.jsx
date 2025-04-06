import { LeafIcon } from "../../Icons/LeafIcon";
import { styled } from "styled-components";

import "./Header.css";
import BasicButton from "../../modules/Button/BasicButton";

import { useContext, useState } from "react";
import SignIn from "../Auth/SignIn/SignIn";
import SignUp from "../Auth/SignUp/SignUp";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../../context/AuthContext";

const StyledTitle = styled.p`
  font-size: 32px;
  text-align: center;
  padding: 5px 7px;
  margin: 3px 5px;
`;

const Header = () => {
  const { auth, logout } = useContext(AuthContext);
  const navi = useNavigate();
  const [isSignUpOpen, setSignUpOpen] = useState(false);

  return (
    <>
      <header className="h-16 px-4 bg-white">
        <div className="header-container">
          <div
            className="logo-section flex flex-row items-center "
            onClick={() => navi("/")}
          >
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
            {!auth.isAuthenticated ? (
              <>
                {/* 로그인 이전 */}
                <BasicButton onClick={() => navi("/sign-in")}>
                  sign-in
                </BasicButton>
                <BasicButton
                  onClick={() => setSignUpOpen(true)}
                  color={"#9be0fd"}
                >
                  sign Up
                </BasicButton>
              </>
            ) : (
              <>
                <BasicButton>마이페이지</BasicButton>
                <BasicButton color={"#C70039"} onClick={logout}>로그아웃</BasicButton>
              </>
            )}
          </div>
        </div>
      </header>

      <SignUp isOpen={isSignUpOpen} onClose={() => setSignUpOpen(false)} />
    </>
  );
};

export default Header;
