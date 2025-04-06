// src/pages/PostQuestionPage.jsx

import axios from "axios";
import React, { useContext, useEffect, useState } from "react";
import { AuthContext } from "../../../context/AuthContext";
import { useNavigate, useParams } from "react-router-dom";

const PostAnswerPage = () => {
    const { id } = useParams();
    const { auth } = useContext(AuthContext);
    const navi = useNavigate();
    const [title, setTitle] = useState("");
    const [body, setBody] = useState("");
    const [tags, setTags] = useState("");

  useEffect(() => {
    if (!auth.isAuthenticated) {
      alert("로그인이 필요합니다!");
      navi("/sign-in");
    }
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("제출됨:", { body });
    // TODO: 백엔드 연동 or 유효성 검사
    axios
      .post(
        "http://localhost/boards/answers",
        {
          memberId: auth.memberInfo.memberId,
          refBoardNo: id,
          answerContent: body,
        },
        {
          headers: {
            Authorization: `Bearer ${auth.authTokens.accessToken}`,
          },
        }
      )
      .then((response) => {
        if (response.status == 201) {
          alert("질문이 등록되었습니다.");
          navi(-1);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="max-w-3xl mx-auto p-6 space-y-6 bg-white rounded-lg shadow mt-10">
      <h1 className="text-2xl font-bold">Answer a public question</h1>

      <form onSubmit={handleSubmit} className="space-y-6">
        {/* Body */}
        <div>
          <label className="block font-semibold mb-1">
            Body <span className="text-red-500">*</span>
          </label>
          <textarea
            rows="10"
            className="w-full border rounded p-2"
            placeholder="Include all the information someone would need to answer your question"
            value={body}
            onChange={(e) => setBody(e.target.value)}
          />
        </div>
        {/* Submit */}
        <div className="text-right">
          <button
            type="submit"
            className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded"
          >
            Review your question
          </button>
        </div>
      </form>
    </div>
  );
};

export default PostAnswerPage;
