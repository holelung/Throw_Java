// src/pages/QuestionDetailPage.jsx
import { useNavigate, useParams } from "react-router-dom";
import {
  CommentsList,
  QuestionContent,
  QuestionHeader,
  QuestionTags,
} from "./QuestionDetailComponents";
import { useContext, useEffect, useState } from "react";
import { AuthContext } from "../../../context/AuthContext";
import axios from "axios";
import BasicButton from "../../modules/Button/BasicButton";
import AnswerList from "./AnswerList";

const QuestionDetailPage = () => {
  const { auth } = useContext(AuthContext);
  const { id } = useParams();
  const [question, setQuestion] = useState(null);
  const [loading, setLoading] = useState(true);
  const navi = useNavigate();
  const [error, setError] = useState(false);


  useEffect(() => {
    axios.get(`http://localhost/boards/${id}`)
      .then((response) => {
        setQuestion(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.log(error);
        setError(true);
        setLoading(false);
      });

  }, [id])
  
  const handleDelete = (e) => {
    e.preventDefault();
    if (confirm("삭제하시겠습니까?")) {
      axios.delete(`http://localhost/boards/questions`, {
        memberId: auth.memberInfo.memberId,
        questionNo: id,
      }, {
        headers: {
          Authorization: `Bearer ${auth.authTokens.accessToken}`,
        }
      }).then(() => {
        setQuestion({
          questionTitle: "삭제중..",
          questionContent: " 삭제중..",
          memberId: "삭제중...",
        });
        
        setTimeout(() => {
          alert("삭제완료");
          navi("/");
        }, 3000);
      }).catch((error) => {
        console.log(error);
      });
    }
  };

  const handleBack = () => {
    navi(-1);
  };
  if (loading) {
    return (
      <QuestionHeader>
        <h2>게시글을 불러오는 중입니다....</h2>
      </QuestionHeader>
    );
  }

  if (error) {
    return (
      <QuestionHeader>
        <h2>게시글을 찾을 수 없습니다.</h2>
      </QuestionHeader>
    );
  }
  
  const questionSave = () => {
    // console.log("gg");
    axios
      .post(
        `http://localhost/boards/save`,
        {
          questionNo: id,
        },
        {
          headers: {
            Authorization: `Bearer ${auth.authTokens.accessToken}`,
          },
        }
      )
      .then((response) => {
        console.log(response);
        if (response.status == 200) alert("저장목록에 추가되었습니다.");
      })
      .catch((error) => {
        alert(error.response.data["error-message"]);
      });
  }

  const recommend = () => {
    axios.put(
      `http://localhost/boards/questions/up`,
      {
        questionNo: id,
        memberId: auth.memberInfo.memberId,
      },
      {
        headers: {
          Authorization: `Bearer ${auth.authTokens.accessToken}`,
        },
      }
    ).then(response => {
      console.log(response);
      if (response.status == 204) {
        alert("추천되었습니다.");
      }
    }).catch(error => {
      console.log(error);
    });
  }

  return (
    <div className="max-w-5xl mx-auto p-6 space-y-8 bg-white">
      <QuestionHeader
        title={question.questionTitle}
        createdAt={question.createTime}
        modifiedAt={question.modifiedTime}
        views={question.viewCount}
      />
      <div className="text-sm m-0.5 flex justify-end">
        <button type="button" className="border rounded-2xl px-3 py-1 mx-2" onClick={questionSave}>저장</button>
        <button type="button" className="border rounded-2xl px-3 py-1" onClick={recommend}>추천</button>
      </div>

      <QuestionContent body={question.questionContent} />
      <BasicButton onClick={() => navi(`/answer/${question.questionNo}`)}>
        답변 작성
      </BasicButton>
      {/* <QuestionTags tags={question.tags} /> */}
      {/* <CommentsList comments={question.comments} /> */}
      <AnswerList questionNo={question.questionNo} />
    </div>
  );
};

export default QuestionDetailPage;
