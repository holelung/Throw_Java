// src/pages/QuestionDetailPage.jsx

import {
  AnswerList,
  CommentsList,
  QuestionContent,
  QuestionHeader,
  QuestionTags,
} from "./QuestionDetailComponents";

const QuestionDetailPage = () => {
  // 임시 데이터
  const question = {
    title:
      "In Spring Boot can I use the same Entity for multiple tables with the same structure",
    createdAt: "1 month ago",
    modifiedAt: "today",
    views: 143,
    body: `I have multiple tables with different names but they have the same structure...`,
    code: `@Data\n@Entity\n@Table(name = \"APPLICATIONS\", schema = \"AIM\")\npublic class Application2 { }`,
    tags: ["java", "spring", "spring-boot", "hibernate", "jpa"],
    comments: [
      "maybe check this: baeldung.com/jpa-mapping-single-entity-to-multiple-tables – Stultsuke",
      "This is when you want to have single Entity... – ivoronine",
    ],
  };

  const answers = [
    {
      id: 1,
      body: `You can create a base entity and inherit your other entities from it...`,
      code: `@Getter\n@Setter\n@MappedSuperclass\npublic abstract class BaseEntityAudit {\n  private String createdBy;\n  private String updatedBy;\n}`,
      user: "Vadim Kotov",
      time: "edited 31 mins ago",
    },
  ];

  return (
    <div className="max-w-5xl mx-auto p-6 space-y-8 bg-white">
      <QuestionHeader
        title={question.title}
        createdAt={question.createdAt}
        modifiedAt={question.modifiedAt}
        views={question.views}
      />
      <QuestionContent body={question.body} code={question.code} />
      <QuestionTags tags={question.tags} />
      <CommentsList comments={question.comments} />
      <AnswerList answers={answers} />
    </div>
  );
};

export default QuestionDetailPage;
