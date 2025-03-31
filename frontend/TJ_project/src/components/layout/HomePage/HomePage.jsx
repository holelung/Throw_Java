import { useNavigate } from "react-router-dom";
import BasicButton from "../../modules/Button/BasicButton";
import Board from "../Board/Board";
import "./HomePage.css";

const HomePage = () => {
  const navi = useNavigate();
  return (
    <>
      <div className="home-page">
        <div className="home-title">
          <p>HotQuestions</p>
          <BasicButton color={"#ffcd64"} onClick={() => navi("/askQuestion")}>
            Ask Question
          </BasicButton>
        </div>

        <Board></Board>
      </div>
    </>
  );
};

export default HomePage;
