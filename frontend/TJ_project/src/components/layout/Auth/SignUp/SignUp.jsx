import { useState } from "react";
import BasicButton from "../../../modules/Button/BasicButton";
import BasicInput from "../../../modules/Input/BasicInput";
import "./SignUp.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const SignUp = ({ isOpen, onClose }) => {
  const navi = useNavigate();
  const [memberId, setMemberId] = useState('');
  const [memberPw, setMemberPw] = useState('');
  const [memberName, setMemberName] = useState("");
  const [email, setEmail] = useState('');
  const [msg, setMsg] = useState('');

  const checkMemberPwIsSame = (e) => {
    if (e.target.value === memberPw) {
      setMsg("비밀번호가 동일합니다");
    } else {
      setMsg("비밀번호가 다릅니다.")
    }
  }

  const signUp = () => {
    axios.post("http://localhost/members", {
      memberId: memberId,
      memberPw: memberPw,
      memberName: memberName,
      email: email,
    })
      .then((result) => {
        console.log(result);
        if (result.status == 201) {
          alert("회원가입에 성공했습니다.");
          onClose();
          setTimeout(() => {
            navi("/");
          }, 1000)
        }
    })
      .catch((error) => {
        console.log(error);
        alert(error.response.data.memberId);
    })
  };

  if (!isOpen) return null;
  return (
    <>
      <div className="modal-overlay">
        <div className="modal-box">
          <div className="modal-header flex items-center justify-between mb-3 text-2xl">
            <h2>회원가입</h2>
            <button className="close-button" onClick={onClose}>
              x
            </button>
          </div>
          <form>
            <BasicInput type={"text"} id={"memberId"} onChange={(e)=>setMemberId(e.target.value)}>
              아이디
            </BasicInput>
            <BasicInput type={"password"} id={"memberPw"} onChange={(e)=>setMemberPw(e.target.value)}>
              비밀번호
            </BasicInput>
            <BasicInput type={"password"} id={"checkPw"} onChange={(e)=>checkMemberPwIsSame(e)}>
              비밀번호 확인
            </BasicInput>
            <label className="text-[14px] px-2">{msg}</label>
            <BasicInput type={"text"} id={"memberName"} onChange={(e)=>setMemberName(e.target.value)}>
              이름
            </BasicInput>
            <BasicInput type={"text"} id={"memberEmail"} onChange={(e)=>setEmail(e.target.value)}>
              이메일
            </BasicInput>
            <div className="flex justify-end mt-3">
              <BasicButton color={"#9be0fd"} onClick={()=>signUp()}>회원가입</BasicButton>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default SignUp;
