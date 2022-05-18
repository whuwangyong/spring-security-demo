CREATE TABLE testdb.user
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(20),
    gender char(1),
    salary int(11),
    password varchar(64),
    phone char(11),
    register_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_login_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    role varchar(20) DEFAULT 'ROLE_USER' NOT NULL,
    enabled tinyint(1) DEFAULT '1'
)engine=Innodb, charset = utf8mb4;
CREATE UNIQUE INDEX user_name_uindex ON testdb.user (name);
INSERT INTO testdb.user (id, name, gender, salary, password, phone, register_time, last_login_time, role, enabled) VALUES (1, '马化腾', '1', 99999999, '$2a$10$xeotKecdh84Jf7v/5hpt1.YFdpLM6T6HkCF0m/61zJRhEVNSxwPLa', '19921899999', '2020-09-28 15:54:22', '2020-09-28 15:54:22', 'ROLE_ROOT', 1);
INSERT INTO testdb.user (id, name, gender, salary, password, phone, register_time, last_login_time, role, enabled) VALUES (2, '张小龙', '1', 88888889, '$2a$10$xeotKecdh84Jf7v/5hpt1.YFdpLM6T6HkCF0m/61zJRhEVNSxwPLa', '19921809309', '2020-09-28 15:54:22', '2020-09-28 15:54:22', 'ROLE_ADMIN', 1);
INSERT INTO testdb.user (id, name, gender, salary, password, phone, register_time, last_login_time, role, enabled) VALUES (3, '老李', '1', 20000, '$2a$10$xeotKecdh84Jf7v/5hpt1.YFdpLM6T6HkCF0m/61zJRhEVNSxwPLa', '13163295776', '2020-09-28 15:54:22', '2020-09-28 15:54:22', 'ROLE_USER', 1);
INSERT INTO testdb.user (id, name, gender, salary, password, phone, register_time, last_login_time, role, enabled) VALUES (4, '小王', '0', 10000, '$2a$10$xeotKecdh84Jf7v/5hpt1.YFdpLM6T6HkCF0m/61zJRhEVNSxwPLa', '19921809309', '2020-09-28 15:54:22', '2020-09-28 15:54:22', 'ROLE_USER', 1);
INSERT INTO testdb.user (id, name, gender, salary, password, phone, register_time, last_login_time, role, enabled) VALUES (5, '小刘', '0', 12000, '$2a$10$xeotKecdh84Jf7v/5hpt1.YFdpLM6T6HkCF0m/61zJRhEVNSxwPLa', '19921809309', '2020-09-28 15:54:22', '2020-09-28 15:54:22', 'ROLE_USER', 1);
INSERT INTO testdb.user (id, name, gender, salary, password, phone, register_time, last_login_time, role, enabled) VALUES (6, '小赵', '1', 8000, '$2a$10$xeotKecdh84Jf7v/5hpt1.YFdpLM6T6HkCF0m/61zJRhEVNSxwPLa', '19921809309', '2020-09-28 15:54:22', '2020-09-28 15:54:22', 'ROLE_USER', 1);