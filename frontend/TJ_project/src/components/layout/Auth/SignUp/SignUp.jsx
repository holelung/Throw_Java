import BasicButton from "../../../modules/Button/BasicButton";
import BasicInput from "../../../modules/Input/BasicInput";
import "./SignUp.css";

const SignUp = ({ isOpen, onClose }) => {
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
            <BasicInput type={"text"} id={"memberId"}>
              아이디
            </BasicInput>
            <BasicInput type={"password"} id={"memberPw"}>
              비밀번호
            </BasicInput>
            <BasicInput type={"password"} id={"checkPw"}>
              비밀번호 확인
            </BasicInput>
            <BasicInput type={"text"} id={"memberName"}>
              이름
            </BasicInput>
            <BasicInput type={"text"} id={"memberEmail"}>
              이메일
            </BasicInput>
            <div className="flex justify-end mt-3">
              <BasicButton color={"#9be0fd"}>회원가입</BasicButton>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default SignUp;
