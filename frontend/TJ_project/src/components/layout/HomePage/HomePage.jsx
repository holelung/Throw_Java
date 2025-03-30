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
        <div className="board-data">
          <div className="board-stats">
            
          </div>
          <div className="board-info"></div>
        </div>
      </div>
    </>
  );
};

export default HomePage;