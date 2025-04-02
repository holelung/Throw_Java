import React from "react";
import ReactMarkdown from "react-markdown";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { oneDark } from "react-syntax-highlighter/dist/esm/styles/prism";

export const QuestionHeader = ({ title, createdAt, modifiedAt, views }) => (
  <div>
    <h1 className="text-2xl font-bold mb-1">{title}</h1>
    <p className="text-sm text-gray-500">
      Asked {createdAt} · Modified {modifiedAt} · Viewed {views} times
    </p>
  </div>
);

export const QuestionContent = ({ body, code }) => (
  <div className="prose max-w-none">
    <div className="prose max-w-none">
      <ReactMarkdown>{body}</ReactMarkdown>
      <SyntaxHighlighter language="java" style={oneDark} className="rounded-md">
        {code}
      </SyntaxHighlighter>
    </div>
  </div>
);

export const QuestionTags = ({ tags }) => (
  <div className="flex gap-2 flex-wrap">
    {tags.map((tag) => (
      <span key={tag} className="bg-gray-100 text-sm px-2 py-1 rounded">
        {tag}
      </span>
    ))}
  </div>
);

export const CommentsList = ({ comments }) => (
  <div className="mt-4 border-t pt-4 space-y-2 text-sm">
    {comments.map((comment, idx) => (
      <div key={idx}>{comment}</div>
    ))}
  </div>
);

export const AnswerList = ({ answers }) => (
  <div className="mt-10">
    <h2 className="text-xl font-semibold mb-4">{answers.length} Answers</h2>
    <div className="space-y-8">
      {answers.map((answer) => (
        <div key={answer.id} className="border-t pt-4">
          <div className="prose max-w-none">
            <ReactMarkdown>{answer.body}</ReactMarkdown>
            <SyntaxHighlighter
              language="java"
              style={oneDark}
              className="rounded-md"
            >
              {answer.code}
            </SyntaxHighlighter>
          </div>
          <div className="text-xs text-gray-500 mt-2">
            answered by <span className="text-blue-500">{answer.user}</span> ·{" "}
            {answer.time}
          </div>
        </div>
      ))}
    </div>
  </div>
);
