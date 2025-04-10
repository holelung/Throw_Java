const BasicInput = ({ children, type, id , onChange }) => {
  return (
    <>
      <div className="form-floating flex flex-col my-2 mx-1">
        <label className="px-3 mb-0.5">{children}</label>
        <input
          type={type}
          id={id}
          placeholder={children}
          onChange={onChange}
          className="p-3 border rounded-2xl"
        />
      </div>
    </>
  );
};

export default BasicInput;
