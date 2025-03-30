import BasicButton from "../../modules/Button/BasicButton";
import "./HomePage.css";

const HomePage = () => {

  
  return (
    <>
      <div className="home-title">
        <p>HotQuestions</p>
        <BasicButton color={"#ffcd64"}>Ask Question</BasicButton>
      </div>
      <div className="board-container">
        <div className="board">
          <div className="board-stats"></div>
          <div className=""></div>
        </div>
      </div>
    </>
  );
};

export default HomePage;