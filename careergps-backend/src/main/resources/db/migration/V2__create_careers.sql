CREATE TABLE IF NOT EXISTS careers (
    id BIGSERIAL PRIMARY KEY,
    category_id BIGINT NOT NULL,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    reality_check TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    work_environment TEXT,

    CONSTRAINT fk_career_category
        FOREIGN KEY (category_id)
        REFERENCES career_categories(id)
);