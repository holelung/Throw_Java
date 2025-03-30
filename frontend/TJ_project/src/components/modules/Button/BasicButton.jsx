import './Button.css';

const BasicButton = ({ children, color }) => {

  return (
    <>
      <button className='basic-btn' style={{ backgroundColor: color, borderColor:color }}>{children}</button>
    </>

  );
}

export default BasicButton;