import { useNavigate } from "react-router-dom";
import Board from "../../modules/Board/Board";
import BasicButton from "../../modules/Button/BasicButton";

const Saves = () => {
  const navi = useNavigate();
  return (
    <>
      <div className="title-area">
        <div className="home-title">
          <p>Save Questions</p>
          <BasicButton color={"#ffcd64"} onClick={() => navi("/askQuestion")}>
            Ask Question
          </BasicButton>
        </div>

        <Board></Board>
      </div>
    </>
  );
};

export default Saves;
