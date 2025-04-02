import { Route, Routes, useLocation } from "react-router-dom";
import "./App.css";

import Sidebar from "./components/layout/Sidebar/Sidebar";
import HomePage from "./components/layout/HomePage/HomePage";
import Header from "./components/layout/Header/Header";
import Saves from "./components/layout/Saves/Saves";

import SignIn from "./components/layout/Auth/SignIn/SignIn";
import SignUp from "./components/layout/Auth/SignUp/SignUp";
import QuestionPage from "./components/layout/QuestionPage/QuestionPage";
import PostQuestionPage from "./components/layout/PostQuestionPage/PostQuestionPage";
import { useEffect } from "react";
import Footer from "./components/layout/Footer/Footer";
import QuestionDetailPage from "./components/layout/QuestionDetail/QuestinoDetailPage";

function App() {
  const location = useLocation();
  // 사이드바를 제외하고 싶은 경로 목록
  const noSidebarRoutes = ["/sign-in", "/askQuestion"];
  const isSidebarVisible = !noSidebarRoutes.includes(location.pathname);

  useEffect(() => {
    if (!isSidebarVisible) {
      document.querySelector("body").style.backgroundColor = "rgb(241,242,243)";
    } else {
      document.querySelector("body").style.backgroundColor = "white";
    }
  });

  return (
    <>
      <Header />
      <div className="main flex flex-row">
        {isSidebarVisible && <Sidebar />}
        <div className="main-page-section">
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/questions" element={<QuestionPage />} />
            <Route path="/saves" element={<Saves />} />
            <Route path="/askQuestion" element={<PostQuestionPage />} />
            <Route path="/sign-in" element={<SignIn />} />
            <Route path="/sign-up" element={<SignUp />} />
            <Route path="/questionDetails" element={<QuestionDetailPage />} />
            <Route
              path="/*"
              element={<h1>존재하지 않는 페이지 요청입니다.</h1>}
            />
          </Routes>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default App;
