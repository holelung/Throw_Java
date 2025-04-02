// src/pages/PostQuestionPage.jsx

import React, { useState } from "react";

const PostQuestionPage = () => {
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const [tags, setTags] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("제출됨:", { title, body, tags });
    // TODO: 백엔드 연동 or 유효성 검사
  };

  return (
    <div className="max-w-3xl mx-auto p-6 space-y-6 bg-white rounded-lg shadow mt-10">
      <h1 className="text-2xl font-bold">Ask a public question</h1>

      <form onSubmit={handleSubmit} className="space-y-6">
        {/* Title */}
        <div>
          <label className="block font-semibold mb-1">
            Title <span className="text-red-500">*</span>
          </label>
          <input
            type="text"
            className="w-full border rounded p-2"
            placeholder="e.g. How to center a div in CSS?"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
          <p className="text-gray-500 text-sm mt-1">
            Be specific and imagine you’re asking a question to another person
          </p>
        </div>

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

        {/* Tags */}
        <div>
          <label className="block font-semibold mb-1">
            Tags <span className="text-red-500">*</span>
          </label>
          <input
            type="text"
            className="w-full border rounded p-2"
            placeholder="e.g. react spring oracle"
            value={tags}
            onChange={(e) => setTags(e.target.value)}
          />
          <p className="text-gray-500 text-sm mt-1">
            Add up to 5 tags to describe what your question is about
          </p>
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

export default PostQuestionPage;
