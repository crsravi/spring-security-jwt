insert into USER (user_id,USERNAME, PASSWORD)
    values (1,'user3','$2a$10$8c7px/OTtU17oIPtjOvXIu7eVaqs6sCClPfq2EJB6EMk0nTSjR3Fy');

insert into USER (user_id,USERNAME, PASSWORD)
    values (2,'user4','$2a$10$HWo0ynoUCtGwxPJ7xLtBd./VOe0obdSaEXnI1AfgbsMS8PlrQBX.a');

INSERT INTO roles (role_id,name) VALUES (1,'USER');
INSERT INTO roles (role_id,name) VALUES (2,'ADMIN');

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);

