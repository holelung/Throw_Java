import "./Button.css";

const BasicButton = ({ children, color, onClick }) => {
  return (
    <>
      <button
        className="basic-btn"
        onClick={onClick}
        style={{ backgroundColor: color, borderColor: color }}
      >
        {children}
      </button>
    </>
  );
};

export default BasicButton;
