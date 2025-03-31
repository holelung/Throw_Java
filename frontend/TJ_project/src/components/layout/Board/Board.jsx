import "./Board.css";

const Board = () => {
  return (
    <>
      <div className="board-container">
        <div className="board-data">
          <div className="board-stats">
            <p>1 votes</p>
            <p>2 answers</p>
            <p>31 views</p>
          </div>
          <div className="board-info">
            <p className="board-title">
              JAVA main thread waiting for executor service
            </p>
            <p className="board-content">
              Is there a way to print "noise3" before all the "Aroma" are
              printed? The rest of the main method always waits for the
              executorservice shutdown, but I want them to run ...
            </p>
            <div className="tags-and-info">
              <div className="tag-area">Java</div>
              <div className="writers-info">user/ 32asked/ 3 mins ago</div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};
export default Board;
