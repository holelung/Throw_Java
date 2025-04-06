import "./Board.css";

const Board = ({ onClick, question }) => {
  return (
    <>
      <div
        key={question.questionNo}
        className="board-container"
        onClick={onClick}
      >
        <div className="board-data">
          <div className="board-stats">
            <p>{question.recommendScore} votes</p>
            <p>{question.answerCount} answers</p>
            <p>{question.viewCount} views</p>
          </div>
          <div className="board-info">
            <p className="board-title">{question.questionTitle}</p>
            <p className="board-content">{question.questionContent}</p>
            <div className="tags-and-info">
              <div className="writers-info text-xs text-gray-500 mt-2">
                Asked by{" "}
                <span className="text-blue-500">{question.memberId}</span> ·{" "}
                {question.createTime}
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};
export default Board;
