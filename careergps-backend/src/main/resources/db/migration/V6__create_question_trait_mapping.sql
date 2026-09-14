CREATE TABLE IF NOT EXISTS question_trait_mapping (
    id BIGSERIAL PRIMARY KEY,
    option_id BIGINT NOT NULL,
    trait_id BIGINT NOT NULL,
    score INT NOT NULL,

    CONSTRAINT fk_qtm_option
        FOREIGN KEY (option_id)
        REFERENCES question_options(id),

    CONSTRAINT fk_qtm_trait
        FOREIGN KEY (trait_id)
        REFERENCES traits(id)
);