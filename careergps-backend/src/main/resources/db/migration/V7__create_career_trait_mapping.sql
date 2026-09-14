CREATE TABLE IF NOT EXISTS career_trait_mapping (
    id BIGSERIAL PRIMARY KEY,
    career_id BIGINT NOT NULL,
    trait_id BIGINT NOT NULL,
    weight INT NOT NULL,

    CONSTRAINT fk_ctm_career
        FOREIGN KEY (career_id)
        REFERENCES careers(id),

    CONSTRAINT fk_ctm_trait
        FOREIGN KEY (trait_id)
        REFERENCES traits(id)
);