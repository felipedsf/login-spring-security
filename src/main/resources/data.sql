INSERT INTO role (description) VALUES ('user');
INSERT INTO role (description) VALUES ('admin');

INSERT INTO user (name, password, user_role, created_date) VALUES ('user', 'user', 1, CURRENT_TIMESTAMP());
