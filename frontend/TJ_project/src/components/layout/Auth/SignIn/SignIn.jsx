import BasicButton from "../../../modules/Button/BasicButton";
import "./SignIn.css";

const SignIn = ({ isOpen, onClose }) => {
  console.log("여기는 SignIn" + isOpen);
  if (!isOpen) return null;

  return (
    <>
      <div className="modal-overlay">
        <div className="modal-box">
          <div className="modal-header flex items-center justify-between mb-3 text-2xl">
            <h2>로그인</h2>
            <button className="close-button" onClick={onClose}>
              x
            </button>
          </div>
          <form>
            <input
              type="text"
              placeholder="아이디"
              className="w-full p-3 mb-2 border-2 rounded-xl border-gray-600"
            />{" "}
            <input
              type="password"
              placeholder="비밀번호"
              className="w-full p-3 mb-2 border-2 border-gray-600 rounded-xl text-gray-800 placeholder-gray-400 bg-white "
              style={{ color: "black" }}
            />
            <div className="flex justify-end">
              <BasicButton color={"#33ffc5"}>sign-in</BasicButton>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default SignIn;
