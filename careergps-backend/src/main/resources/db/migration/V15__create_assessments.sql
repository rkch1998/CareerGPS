CREATE TABLE assessments (
    id BIGSERIAL PRIMARY KEY,
    current_class VARCHAR(30) NOT NULL,
    stream VARCHAR(30),
    age INTEGER,
    status VARCHAR(30) NOT NULL DEFAULT 'IN_PROGRESS',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE assessment_answers (
    id BIGSERIAL PRIMARY KEY,
    assessment_id BIGINT NOT NULL REFERENCES assessments(id),
    question_id BIGINT NOT NULL REFERENCES questions(id),
    option_id BIGINT NOT NULL REFERENCES question_options(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_assessment_question UNIQUE (assessment_id, question_id)
);
CREATE INDEX ix_assessment_answers_assessment_id ON assessment_answers(assessment_id);
CREATE INDEX ix_assessment_answers_option_id ON assessment_answers(option_id);
