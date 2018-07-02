-- EMPLOYEE PHOTOS
insert into file(id, content) values
(0,  FILE_READ('./src/main/resources/static/photos/face.jpg'));

--AUTHENTICATION
INSERT into user(id, username, password, name, email, experience, skill, active, picture_id) VALUES
(1, 'user', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'User Professor','Professor1@Professor.com', 'experience 1, experience 2, experience 3.', 'skill 1, skill 2, Skills 3.',  TRUE, 0),
(2, 'professor', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Professor ','Professor@Professor.com', 'experience.', 'skill 1.',  TRUE, 0);


--ROLES
insert into role(id, role) values
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(1, 1);

--DISCIPLINE
INSERT INTO  discipline(id, name, description) VALUES
(201, 'Linguagem oral e escrita', 'Operar a linguagem '),
(202, 'Matematica', 'Pensamento lógico-matemático.'),
(203, 'Natureza e Sociedade', 'formação de conceitos e valores'),
(204, 'Matematica', 'atividades significativas e construtivas dentro do contexto de sua vida.');

--CONTENT
INSERT INTO  content(id, name, objective, discipline_id) VALUES
(301, 'Vogais', 'Sejam capaz de reconhecer as vogais', 201),
(302, 'Inicial do nome', 'Sejam capaz de reconhecer a letra inicial do nome', 201),
(304, 'família', 'Identificar, nomear e reconhecer a família e sua importância;', 203),
(305, 'Numeral 5', 'Sejam capaz de associar o Numeral 5 com a quantidade', 202),
(306, 'Noção de posição', 'Sejam capaz de  diferenciar posições, frete atrás', 202);

--ACTIVITY
INSERT INTO activity(id, name, objective, procedure, resource, content_id) VALUES
(501, 'Recortar Letras', 'reconhecer as vogais', 'procedure', 'Tesoura, cola, revistas',301),
(502, 'Recortar Numeros', 'reconhecer o numeral 5', 'procedure', 'Tesoura, cola, revistas',305),
(503, 'Desenho Livre', 'reconhecer o proprio nome', 'procedure', 'Lapis de cor, papel sulfite',302),
(504, 'Colagem', 'desenvolver coordenação motora fina', 'procedure', 'cola, papeis coloridos',306),
(505, 'Pintura com guache', 'desenvolver a coordenação motora', 'procedure', 'tela, guache, pinceis',306);

--ROUTINE
INSERT INTO  routine(id,  hour, name, description, activity_id) VALUES
(401, '08:10', 'Chegada, recepção', 'descrição', 501),
(402, '08:30', 'Alimentação', 'descrição', 501),
(403, '09:30', 'Atividade didático-pedagógicas', 'descrição', 501),
(404, '10:30', 'Brincadeira ao ar livre', 'descrição', 501),
(405, '11:30', 'Higiene', 'descrição', 501),
(406, '12:00', 'Repouso', 'descrição', 501),
(407, '13:15', 'Atividade Livre', 'descrição', 501),
(408, '14:30', 'Hora do Conto', 'descrição', 501),
(409, '15:30', 'Hora da Musica', 'descrição', 501),
(410, '16:45', 'Saída', 'descrição', 501);

--CLASS_PLAN
INSERT INTO  class_plan(id, data, description, evaluation, routine_id)  VALUES
(701, '2018-07-02', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 401),
(702, '2018-07-02', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 409),
(703, '2018-07-02', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 407),
(704, '2018-07-03', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 401),
(705, '2018-07-03', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 409),
(706, '2018-07-03', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 407),
(707, '2018-07-04', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 401),
(708, '2018-07-04', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 409),
(709, '2018-07-04', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 407),
(710, '2018-07-04', 'Apresentar as vogais', 'ser capaz de conhecer as vogais', 409);


