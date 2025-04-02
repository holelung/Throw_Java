import { useNavigate } from "react-router-dom";
import "./QuestionPage.css";
import BasicButton from "../../modules/Button/BasicButton";
import Board from "../../modules/Board/Board";

const QuestionPage = () => {
  const navi = useNavigate();

  return (
    <>
      <div className="title-area">
        <div className="home-title">
          <p>Recent Questions</p>
          <BasicButton color={"#ffcd64"} onClick={() => navi("/askQuestion")}>
            Ask Question
          </BasicButton>
        </div>

        <Board></Board>
      </div>
    </>
  );
};

export default QuestionPage;
