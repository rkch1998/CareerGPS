INSERT INTO questions (question_text, question_type, display_order, active) VALUES
('What class are you currently studying in?', 'CURRENT_SITUATION', 1, true),
('Which stream are you studying?', 'CURRENT_SITUATION', 2, true),
('Which activities sound most interesting to you?', 'INTEREST', 3, true),
('If you had a free day, what would you enjoy doing?', 'INTEREST', 4, true),
('Which school subject do you enjoy most?', 'INTEREST', 5, true),
('Which describes you best?', 'STRENGTH', 6, true),
('When faced with a challenge, what do you usually do?', 'STRENGTH', 7, true),
('Which type of work sounds better?', 'WORK_PREFERENCE', 8, true),
('Would you enjoy traveling for work?', 'WORK_PREFERENCE', 9, true),
('Would you rather work with:', 'WORK_PREFERENCE', 10, true),
('What matters most in a future career?', 'VALUE', 11, true),
('Which achievement would make you happiest?', 'VALUE', 12, true),
('Would you be willing to move to another city for studies?', 'CONSTRAINT', 13, true),
('Which best describes your study budget?', 'CONSTRAINT', 14, true),
('Are you interested in government jobs?', 'CONSTRAINT', 15, true),
('Which sounds most exciting?', 'FUTURE_GOAL', 16, true),
('How many years are you comfortable studying after Class 12?', 'FUTURE_GOAL', 17, true),
('Would you like to explore careers you may not have heard about?', 'CAREER_DISCOVERY', 18, true),
('Which sounds more exciting?', 'CAREER_DISCOVERY', 19, true),
('What kind of impact would you like to make?', 'CAREER_DISCOVERY', 20, true);

INSERT INTO question_options (question_id, option_text, display_order) VALUES
((SELECT id FROM questions WHERE display_order=1), 'Class 8', 1), ((SELECT id FROM questions WHERE display_order=1), 'Class 9', 2), ((SELECT id FROM questions WHERE display_order=1), 'Class 10', 3), ((SELECT id FROM questions WHERE display_order=1), 'Class 11', 4), ((SELECT id FROM questions WHERE display_order=1), 'Class 12', 5), ((SELECT id FROM questions WHERE display_order=1), 'Diploma', 6), ((SELECT id FROM questions WHERE display_order=1), 'Other', 7),
((SELECT id FROM questions WHERE display_order=2), 'Science', 1), ((SELECT id FROM questions WHERE display_order=2), 'Commerce', 2), ((SELECT id FROM questions WHERE display_order=2), 'Arts', 3), ((SELECT id FROM questions WHERE display_order=2), 'Diploma', 4), ((SELECT id FROM questions WHERE display_order=2), 'Not selected yet', 5),
((SELECT id FROM questions WHERE display_order=3), 'Building apps or websites', 1), ((SELECT id FROM questions WHERE display_order=3), 'Helping sick people', 2), ((SELECT id FROM questions WHERE display_order=3), 'Teaching others', 3), ((SELECT id FROM questions WHERE display_order=3), 'Managing money', 4), ((SELECT id FROM questions WHERE display_order=3), 'Drawing or designing', 5), ((SELECT id FROM questions WHERE display_order=3), 'Protecting the country', 6), ((SELECT id FROM questions WHERE display_order=3), 'Working with nature', 7),
((SELECT id FROM questions WHERE display_order=4), 'Solving puzzles', 1), ((SELECT id FROM questions WHERE display_order=4), 'Playing sports', 2), ((SELECT id FROM questions WHERE display_order=4), 'Creating videos', 3), ((SELECT id FROM questions WHERE display_order=4), 'Reading about science', 4), ((SELECT id FROM questions WHERE display_order=4), 'Fixing machines', 5), ((SELECT id FROM questions WHERE display_order=4), 'Organizing events', 6),
((SELECT id FROM questions WHERE display_order=5), 'Maths', 1), ((SELECT id FROM questions WHERE display_order=5), 'Science', 2), ((SELECT id FROM questions WHERE display_order=5), 'Biology', 3), ((SELECT id FROM questions WHERE display_order=5), 'Computer Science', 4), ((SELECT id FROM questions WHERE display_order=5), 'Commerce', 5), ((SELECT id FROM questions WHERE display_order=5), 'Economics', 6), ((SELECT id FROM questions WHERE display_order=5), 'History', 7), ((SELECT id FROM questions WHERE display_order=5), 'Geography', 8), ((SELECT id FROM questions WHERE display_order=5), 'Art', 9),
((SELECT id FROM questions WHERE display_order=6), 'I enjoy solving problems', 1), ((SELECT id FROM questions WHERE display_order=6), 'I enjoy helping people', 2), ((SELECT id FROM questions WHERE display_order=6), 'I enjoy creating things', 3), ((SELECT id FROM questions WHERE display_order=6), 'I enjoy explaining things', 4), ((SELECT id FROM questions WHERE display_order=6), 'I enjoy leading groups', 5), ((SELECT id FROM questions WHERE display_order=6), 'I enjoy fixing things', 6),
((SELECT id FROM questions WHERE display_order=7), 'Break it into smaller parts', 1), ((SELECT id FROM questions WHERE display_order=7), 'Ask someone for help', 2), ((SELECT id FROM questions WHERE display_order=7), 'Try different ideas', 3), ((SELECT id FROM questions WHERE display_order=7), 'Research online', 4), ((SELECT id FROM questions WHERE display_order=7), 'Practice until it works', 5),
((SELECT id FROM questions WHERE display_order=8), 'Office work', 1), ((SELECT id FROM questions WHERE display_order=8), 'Outdoor work', 2), ((SELECT id FROM questions WHERE display_order=8), 'Both', 3),
((SELECT id FROM questions WHERE display_order=9), 'Yes', 1), ((SELECT id FROM questions WHERE display_order=9), 'Sometimes', 2), ((SELECT id FROM questions WHERE display_order=9), 'No', 3),
((SELECT id FROM questions WHERE display_order=10), 'Computers', 1), ((SELECT id FROM questions WHERE display_order=10), 'People', 2), ((SELECT id FROM questions WHERE display_order=10), 'Animals', 3), ((SELECT id FROM questions WHERE display_order=10), 'Machines', 4), ((SELECT id FROM questions WHERE display_order=10), 'Data', 5), ((SELECT id FROM questions WHERE display_order=10), 'Nature', 6),
((SELECT id FROM questions WHERE display_order=11), 'Helping people', 1), ((SELECT id FROM questions WHERE display_order=11), 'Earning good money', 2), ((SELECT id FROM questions WHERE display_order=11), 'Being creative', 3), ((SELECT id FROM questions WHERE display_order=11), 'Job security', 4), ((SELECT id FROM questions WHERE display_order=11), 'Becoming famous', 5), ((SELECT id FROM questions WHERE display_order=11), 'Solving important problems', 6),
((SELECT id FROM questions WHERE display_order=12), 'Saving lives', 1), ((SELECT id FROM questions WHERE display_order=12), 'Building a successful company', 2), ((SELECT id FROM questions WHERE display_order=12), 'Creating something useful', 3), ((SELECT id FROM questions WHERE display_order=12), 'Teaching students', 4), ((SELECT id FROM questions WHERE display_order=12), 'Representing the country', 5), ((SELECT id FROM questions WHERE display_order=12), 'Discovering something new', 6),
((SELECT id FROM questions WHERE display_order=13), 'Yes', 1), ((SELECT id FROM questions WHERE display_order=13), 'Maybe', 2), ((SELECT id FROM questions WHERE display_order=13), 'No', 3),
((SELECT id FROM questions WHERE display_order=14), 'Low-cost preferred', 1), ((SELECT id FROM questions WHERE display_order=14), 'Moderate budget', 2), ((SELECT id FROM questions WHERE display_order=14), 'Open to all options', 3),
((SELECT id FROM questions WHERE display_order=15), 'Very interested', 1), ((SELECT id FROM questions WHERE display_order=15), 'Maybe', 2), ((SELECT id FROM questions WHERE display_order=15), 'Not interested', 3),
((SELECT id FROM questions WHERE display_order=16), 'Building technology', 1), ((SELECT id FROM questions WHERE display_order=16), 'Treating patients', 2), ((SELECT id FROM questions WHERE display_order=16), 'Running a business', 3), ((SELECT id FROM questions WHERE display_order=16), 'Teaching students', 4), ((SELECT id FROM questions WHERE display_order=16), 'Designing products', 5), ((SELECT id FROM questions WHERE display_order=16), 'Protecting the country', 6),
((SELECT id FROM questions WHERE display_order=17), '1-3 years', 1), ((SELECT id FROM questions WHERE display_order=17), '3-5 years', 2), ((SELECT id FROM questions WHERE display_order=17), '5-8 years', 3), ((SELECT id FROM questions WHERE display_order=17), 'As many as needed', 4),
((SELECT id FROM questions WHERE display_order=18), 'Yes', 1), ((SELECT id FROM questions WHERE display_order=18), 'Maybe', 2), ((SELECT id FROM questions WHERE display_order=18), 'No', 3),
((SELECT id FROM questions WHERE display_order=19), 'Designing robots', 1), ((SELECT id FROM questions WHERE display_order=19), 'Studying space', 2), ((SELECT id FROM questions WHERE display_order=19), 'Protecting computer systems', 3), ((SELECT id FROM questions WHERE display_order=19), 'Understanding human behavior', 4), ((SELECT id FROM questions WHERE display_order=19), 'Growing food efficiently', 5), ((SELECT id FROM questions WHERE display_order=19), 'Creating games', 6),
((SELECT id FROM questions WHERE display_order=20), 'Improve lives', 1), ((SELECT id FROM questions WHERE display_order=20), 'Advance technology', 2), ((SELECT id FROM questions WHERE display_order=20), 'Protect nature', 3), ((SELECT id FROM questions WHERE display_order=20), 'Educate people', 4), ((SELECT id FROM questions WHERE display_order=20), 'Strengthen society', 5), ((SELECT id FROM questions WHERE display_order=20), 'Create entertainment', 6);

INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='TEC' WHERE q.display_order IN (3,10,16,19,20) AND o.option_text IN ('Building apps or websites','Computers','Building technology','Designing robots','Protecting computer systems','Advance technology');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='ANL' WHERE q.display_order IN (4,5,6,7,10) AND o.option_text IN ('Solving puzzles','Maths','I enjoy solving problems','Break it into smaller parts','Data');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='SOC' WHERE q.display_order IN (3,6,10,11,12,16,20) AND o.option_text IN ('Helping sick people','I enjoy helping people','People','Helping people','Saving lives','Treating patients','Improve lives');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='CRT' WHERE q.display_order IN (3,4,5,6,7,11,16,19,20) AND o.option_text IN ('Drawing or designing','Creating videos','Art','I enjoy creating things','Try different ideas','Being creative','Designing products','Creating games','Create entertainment');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='NUM' WHERE q.display_order IN (3,5) AND o.option_text IN ('Managing money','Commerce','Economics');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='LDR' WHERE q.display_order IN (4,6,12,16) AND o.option_text IN ('Organizing events','I enjoy leading groups','Building a successful company','Running a business');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='COM' WHERE q.display_order IN (3,6,12,16,20) AND o.option_text IN ('Teaching others','I enjoy explaining things','Teaching students','Educate people');
INSERT INTO question_trait_mapping (option_id, trait_id, score)
SELECT o.id, t.id, 3 FROM question_options o JOIN questions q ON q.id=o.question_id JOIN traits t ON t.code='DET' WHERE q.display_order IN (7,19) AND o.option_text IN ('Practice until it works','Protecting computer systems');
