import { useNavigate } from "react-router-dom";
import Board from "../../modules/Board/Board";
import BasicButton from "../../modules/Button/BasicButton";
import { useContext, useEffect, useState } from "react";
import axios from "axios";
import { AuthContext } from "../../../context/AuthContext";

const Saves = () => {
  const { auth } = useContext(AuthContext);
  const navi = useNavigate();
  const [questions, setQuestions] = useState([]);
  const [page, setPage] = useState(0);
  const [hasMore, setHasMore] = useState(true);

  useEffect(() => {
    axios
      .get(
        "http://localhost/boards/save",
        {
          params: {
            page: page,
          },
          headers: {
            Authorization: `Bearer ${auth.authTokens.accessToken}`,
          },
        }
      )
      .then((response) => {
        console.log(response);
        setQuestions([...questions, ...response.data]);
        if (response.data.length < 5 || response.data == undefined) {
          setHasMore(false);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }, [page]);

  const handleMore = () => {
    setPage((page) => page + 1);
  };
  
  return (
    <>
      <div className="title-area">
        <div className="home-title">
          <p>Save Questions</p>
          <BasicButton color={"#ffcd64"} onClick={() => navi("/askQuestion")}>
            Ask Question
          </BasicButton>
        </div>

        {questions.map((question) => (
          <Board
            onClick={() => navi(`/questionDetails/${question.questionNo}`)}
            key={question.questionNo}
            question={question}
          />
        ))}
        {hasMore && (
          <BasicButton onClick={handleMore}>더보기버튼이야용</BasicButton>
        )}
      </div>
    </>
  );
};

export default Saves;
