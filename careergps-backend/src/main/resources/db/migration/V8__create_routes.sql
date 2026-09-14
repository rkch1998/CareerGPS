CREATE TABLE IF NOT EXISTS routes (
    id BIGSERIAL PRIMARY KEY,
    career_id BIGINT NOT NULL,
    route_name VARCHAR(255),
    route_description TEXT,

    CONSTRAINT fk_route_career
        FOREIGN KEY (career_id)
        REFERENCES careers(id)
);