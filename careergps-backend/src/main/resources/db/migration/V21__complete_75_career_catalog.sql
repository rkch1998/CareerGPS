INSERT INTO careers (category_id, code, name, description, reality_check, work_environment)
VALUES ((SELECT id FROM career_categories WHERE code='HOS'), 'HOS005', 'Restaurant Manager',
        'Manages restaurant operations, staff and guest experience.',
        'Requires flexible hours and calm problem solving during busy service.',
        'Works in restaurants, hotels and food-service businesses.');
INSERT INTO career_trait_mapping (career_id, trait_id, weight)
SELECT c.id, t.id, 4 FROM careers c JOIN traits t ON t.code='SOC' WHERE c.code='HOS005'
ON CONFLICT (career_id, trait_id) DO NOTHING;
INSERT INTO career_skill_mapping (career_id, skill_id, weight)
SELECT c.id, s.id, 4 FROM careers c JOIN skills s ON s.code='SK021' WHERE c.code='HOS005'
ON CONFLICT (career_id, skill_id) DO NOTHING;
INSERT INTO career_subject_mapping (career_id, subject_id, weight)
SELECT c.id, s.id, 4 FROM careers c JOIN subjects s ON s.code='SUB007' WHERE c.code='HOS005'
ON CONFLICT (career_id, subject_id) DO NOTHING;
INSERT INTO routes (career_id, route_name, route_description, route_type, duration_months, cost_band, entrance_exams, competition_level, relocation_needed)
SELECT c.id, 'Hospitality management route', 'Class 10 → Hospitality course or degree → Restaurant Manager', 'STANDARD', 36, 'Varies', 'Check institution requirements', 'Varies', false FROM careers c WHERE c.code='HOS005';
INSERT INTO route_steps (route_id, step_order, title, detail)
SELECT r.id, 1, 'Class 10', 'Complete school and explore hospitality subjects.' FROM routes r JOIN careers c ON c.id=r.career_id WHERE c.code='HOS005';
INSERT INTO route_steps (route_id, step_order, title, detail)
SELECT r.id, 2, 'Hospitality training', 'Complete a hospitality course or degree and gain practical experience.' FROM routes r JOIN careers c ON c.id=r.career_id WHERE c.code='HOS005';
INSERT INTO route_steps (route_id, step_order, title, detail)
SELECT r.id, 3, 'Restaurant Manager', 'Build guest-service, team coordination and operations experience.' FROM routes r JOIN careers c ON c.id=r.career_id WHERE c.code='HOS005';
