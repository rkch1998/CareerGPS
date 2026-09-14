CREATE TABLE skills (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(120) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE subjects (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(120) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE career_skill_mapping (
    id BIGSERIAL PRIMARY KEY,
    career_id BIGINT NOT NULL REFERENCES careers(id),
    skill_id BIGINT NOT NULL REFERENCES skills(id),
    weight INT NOT NULL CHECK (weight BETWEEN 1 AND 5),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_career_skill UNIQUE (career_id, skill_id)
);
CREATE TABLE career_subject_mapping (
    id BIGSERIAL PRIMARY KEY,
    career_id BIGINT NOT NULL REFERENCES careers(id),
    subject_id BIGINT NOT NULL REFERENCES subjects(id),
    weight INT NOT NULL CHECK (weight BETWEEN 1 AND 5),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_career_subject UNIQUE (career_id, subject_id)
);
ALTER TABLE careers ADD COLUMN IF NOT EXISTS code VARCHAR(30);
UPDATE careers SET code = 'TECH001' WHERE name = 'Software Engineer';
UPDATE careers SET code = 'TECH002' WHERE name = 'Data Scientist';
UPDATE careers SET code = 'TECH003' WHERE name = 'Cybersecurity Analyst';
UPDATE careers SET code = 'MED001' WHERE name = 'Doctor';
UPDATE careers SET code = 'MED002' WHERE name = 'Nurse';
UPDATE careers SET code = 'MED003' WHERE name = 'Physiotherapist';
UPDATE careers SET code = 'BUS001' WHERE name = 'Chartered Accountant';
UPDATE careers SET code = 'BUS002' WHERE name = 'Business Analyst';
UPDATE careers SET code = 'BUS003' WHERE name = 'Marketing Manager';
UPDATE careers SET code = 'ART001' WHERE name = 'Graphic Designer';
UPDATE careers SET code = 'ART002' WHERE name = 'UI UX Designer';
UPDATE careers SET code = 'ART003' WHERE name = 'Animator';
UPDATE careers SET code = 'GOV001' WHERE name = 'IAS Officer';
UPDATE careers SET code = 'GOV002' WHERE name = 'IPS Officer';
UPDATE careers SET code = 'DEF001' WHERE name = 'Indian Army Officer';
ALTER TABLE careers ALTER COLUMN code SET NOT NULL;
ALTER TABLE careers ADD CONSTRAINT uk_careers_code UNIQUE (code);
ALTER TABLE routes ADD COLUMN IF NOT EXISTS route_type VARCHAR(40) NOT NULL DEFAULT 'STANDARD';
ALTER TABLE routes ADD COLUMN IF NOT EXISTS duration_months INTEGER;
ALTER TABLE routes ADD COLUMN IF NOT EXISTS cost_band VARCHAR(30);
ALTER TABLE routes ADD COLUMN IF NOT EXISTS entrance_exams TEXT;
ALTER TABLE routes ADD COLUMN IF NOT EXISTS competition_level VARCHAR(30);
ALTER TABLE routes ADD COLUMN IF NOT EXISTS relocation_needed BOOLEAN;
CREATE TABLE route_steps (
    id BIGSERIAL PRIMARY KEY,
    route_id BIGINT NOT NULL REFERENCES routes(id) ON DELETE CASCADE,
    step_order INT NOT NULL CHECK (step_order > 0),
    title VARCHAR(200) NOT NULL,
    detail TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_route_step_order UNIQUE (route_id, step_order)
);
ALTER TABLE career_trait_mapping ADD CONSTRAINT uk_career_trait UNIQUE (career_id, trait_id);
ALTER TABLE question_trait_mapping ADD CONSTRAINT uk_question_option_trait UNIQUE (option_id, trait_id);
CREATE INDEX ix_career_skill_mapping_skill_id ON career_skill_mapping(skill_id);
CREATE INDEX ix_career_subject_mapping_subject_id ON career_subject_mapping(subject_id);
CREATE INDEX ix_route_steps_route_id ON route_steps(route_id);
