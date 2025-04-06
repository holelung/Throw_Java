import axios from "axios";
import ReactMarkdown from "react-markdown";
import { useEffect, useState } from "react";


const AnswerList = ({ questionNo }) => {
  const [answers, setAnswers] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost/boards/answers/${questionNo}`)
      .then((response) => {
        console.log(response);
        if (response.status == 200) {
          setAnswers([...answers,...response.data])
        }
      }).catch((error) => {
        console.log(error);
      })
  },[]);

  return (
    <>
      <div className="mt-10">
        <h2 className="text-xl font-semibold mb-4">{answers.length} Answers</h2>
        <div className="space-y-8">
          {answers.map((answer) => (
            <div key={answer.answerNo} className="border-t pt-4">
              <div className="prose max-w-none">
                <ReactMarkdown>{answer.answerContent}</ReactMarkdown>
              </div>
              <div className="text-xs text-gray-500 mt-2">
                answered by <span className="text-blue-500">{answer.memberId}</span>{" "}
                · {answer.createTime}
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
};
export default AnswerList;
