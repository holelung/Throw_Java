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

export const QuestionContent = ({ body }) => (
  <div className="prose max-w-none">
    <div className="prose max-w-none">
      <ReactMarkdown>{body}</ReactMarkdown>
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

