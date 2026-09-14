ALTER TABLE career_categories
    ADD COLUMN IF NOT EXISTS code VARCHAR(20);

UPDATE career_categories
SET code = 'TECH'
WHERE name = 'Technology';

UPDATE career_categories
SET code = 'HLTH'
WHERE name = 'Healthcare';

UPDATE career_categories
SET code = 'BUS'
WHERE name = 'Business';

UPDATE career_categories
SET code = 'ART'
WHERE name = 'Arts';

UPDATE career_categories
SET code = 'GOV'
WHERE name = 'Government';

UPDATE career_categories
SET code = 'TECH'
WHERE code IS NULL AND name = 'Technology';

ALTER TABLE career_categories
    ALTER COLUMN code SET NOT NULL;

CREATE UNIQUE INDEX IF NOT EXISTS ux_career_categories_code
    ON career_categories(code);
