import { LeafIcon } from "../../../Icons/LeafIcon";

import "./SignIn.css";
import BasicButton from "../../../modules/Button/BasicButton";
import { useContext, useState } from "react";
import axios from "axios";
import { AuthContext } from "../../../../context/AuthContext";
import { useNavigate } from "react-router-dom";

const SignIn = () => {
  const {auth, login} = useContext(AuthContext);
  const [password, setPassword] = useState("");
  const [id, setId] = useState("");
  const [msg, setMsg] = useState("");
  const navi = useNavigate();

  function clickSignIn() {
    const regexp = /^[a-zA-Z0-9]{4,20}$/;
    if (!regexp.test(id)) {
      setMsg("아이디 값이 유효하지 않습니다.");
      return;
    }
    
    axios.post("http://localhost/auth/login", {
      memberId: id,
      memberPw: password,
    })
      .then((result) => {
        console.log(result.data);
        const { authTokens, memberInfo } = result.data;
        login(memberInfo, authTokens);
        alert("로그인 성공");

        navi("/");
      })
      .catch((error) => {
        console.log(error);
        alert(error.response.data["error-message"]);
      });
  }

  return (
    <>
      <div className="w-[100%] h-[80vh] flex flex-row items-center justify-center">
        <form className="mt-[30px] bg-white flex flex-col  w-[400px] p-[20px] border border-green-700 rounded-2xl">
          <div className="flex justify-between items-center pr-3">
            <h1 className="text-3xl pl-3">sign in</h1>
            <LeafIcon size={"3x"}></LeafIcon>
          </div>
          <div className="flex flex-col my-2 mx-2">
            <label className="px-3 mb-0.5">아이디</label>
            <input
              type="text"
              placeholder="아이디를 입력하세요"
              className="p-2 border rounded-2xl"
              required
              onChange={(e)=> setId(e.target.value)}
            />
            <label className="text-[13px] text-red-700 ">{msg}</label>
          </div>
          <div className="flex flex-col mt-2 mb-4 mx-2">
            <label className="px-3 mb-0.5">비밀번호</label>
            <input
              type="password"
              placeholder="비밀번호를 입력하세요"
              className="p-2 border rounded-2xl"
              required
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
      
          <BasicButton onClick={clickSignIn}>Sign In</BasicButton>
          <p className="mt-5 mb-3 text-body-secondary">© 2025</p>
        </form>
      </div>
    </>
  );
};

export default SignIn;
