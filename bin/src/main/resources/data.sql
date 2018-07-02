-- EMPLOYEE PHOTOS
insert into file(id, content) values
(0,  FILE_READ('./src/main/resources/static/photos/face.jpg'));

--AUTHENTICATION
INSERT into user(id, username, password, name, email, experience, skill, active, picture_id) VALUES
(1, 'user', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Professor','Professor@Professor.com', 'experience 1, experience 2, experience 3.', 'skill 1, skill 2, Skills 3.',  TRUE, 0);

--ROLES
insert into role(id, role) values
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(1, 1);



INSERT INTO activity(id, name, conteudo, objective, procedure, resource) VALUES
(501, 'name', '301', 'objective', 'procedure', 'resource'),
(502, 'name', '301', 'objective', 'procedure', 'resource'),
(503, 'name', '302', 'objective', 'procedure', 'resource'),
(504, 'name', '302', 'objective', 'procedure', 'resource'),
(505, 'name', '303', 'objective', 'procedure', 'resource'),
(506, 'name', '303', 'objective', 'procedure', 'resource');

