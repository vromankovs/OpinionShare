INSERT INTO roles (id, role) VALUES
  (nextval('roles_seq'), 'USER'),
  (nextval('roles_seq'), 'ADMIN'),
  (nextval('roles_seq'), 'MODERATOR');

INSERT INTO users (id, email, name, password, surname)
values (nextval('users_seq'), 'test@test.com', 'Test', '$2a$10$3YVKafZG02Wtt9Ke0cy1q.WciRDC5GdTFhlaTQ5W/VzQ7Abtig9pS', 'Doe');

INSERT INTO user_role (user_id, role_id)
values ((select id from users where email='test@test.com'), (select id from roles where role='USER'));