CREATE TABLE IF NOT EXISTS question_options (
    id BIGSERIAL PRIMARY KEY,
    question_id BIGINT NOT NULL,
    option_text VARCHAR(255) NOT NULL,
    display_order INT NOT NULL,

    CONSTRAINT fk_question_option
        FOREIGN KEY (question_id)
        REFERENCES questions(id)
);