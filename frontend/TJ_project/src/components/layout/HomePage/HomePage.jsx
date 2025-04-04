import { useNavigate } from "react-router-dom";
import BasicButton from "../../modules/Button/BasicButton";
import Board from "../../modules/Board/Board";
import "./HomePage.css";

const HomePage = () => {
  const navi = useNavigate();
  return (
    <>
      <div className="title-area">
        <div className="home-title">
          <p>HotQuestions</p>
          <BasicButton color={"#ffcd64"} onClick={() => navi("/askQuestion")}>
            Ask Question
          </BasicButton>
        </div>

        <Board onClick={() => navi("/questionDetails")}></Board>
      </div>
    </>
  );
};

export default HomePage;
