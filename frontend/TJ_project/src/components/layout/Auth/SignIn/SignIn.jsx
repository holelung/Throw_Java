import { LeafIcon } from "../../../Icons/LeafIcon";
import BasicInput from "../../../modules/Input/BasicInput";
import "./SignIn.css";
import BasicButton from "../../../modules/Button/BasicButton";

const SignIn = () => {
  function clickSignIn() {
    console.log("SignIn btn clicked");
  }

  return (
    <>
      <div className="w-[100%] h-[80vh] flex flex-row items-center justify-center">
        <form className="mt-[30px] bg-white flex flex-col  w-[400px] p-[20px] border border-green-700 rounded-2xl">
          <div className="flex justify-between items-center pr-3">
            <h1 className="text-3xl pl-3">sign in</h1>
            <LeafIcon size={"3x"}></LeafIcon>
          </div>
          <BasicInput type={"text"} id={"inputId"}>
            아이디
          </BasicInput>
          <BasicInput type={"password"} id={"inputPassword"}>
            비밀번호
          </BasicInput>

          <div className="form-check text-start my-3">
            <input
              className="form-check-input"
              type="checkbox"
              value="remember-me"
              id="flexCheckDefault"
            />
            <label className="form-check-label">Remember me</label>
          </div>
          <BasicButton onClick={clickSignIn}>Sign In</BasicButton>
          <p className="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
        </form>
      </div>
    </>
  );
};

export default SignIn;
