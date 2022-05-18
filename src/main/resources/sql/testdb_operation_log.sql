 use testdb;
drop table if exists operation_log;
CREATE TABLE testdb.operation_log
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    date_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    operation varchar(255),
    operator varchar(20)
)engine=Innodb, charset = utf8mb4;
INSERT INTO testdb.operation_log (id, date_time, operation, operator) VALUES (1, '2020-09-29 21:14:31', 'name=小刘,salary=12000', '张小龙');
INSERT INTO testdb.operation_log (id, date_time, operation, operator) VALUES (2, '2020-09-29 21:28:46', 'name=张小龙,salary=88888889', '张小龙');