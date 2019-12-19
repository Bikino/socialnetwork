
# create table roles (id bigint not null auto_increment, created_on bigint, description varchar(255), modified_on bigint, name varchar(255), primary key (id));
# create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) ;
#
# alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (id);
# alter table user_roles add constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users (id);
#
# INSERT INTO roles(description,name) values ('Admin', 'ADMIN');
# INSERT INTO roles(description,name) values ('User', 'USER');
# INSERT INTO roles(description,name) values ('Manager', 'MANAGER');
#
# INSERT INTO person (id,email,first_name, last_name,password,username) values (11,'admin@gmail.com','Chris', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','chris');
# INSERT INTO person (id,email,first_name, last_name,password,username) values (21,'admin@gmail.com','Abebe', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','abebe');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','Robert', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','robert');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','Mola', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','mola');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','Emmanuel', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','emmanuel');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','Dawit', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','dawit');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','Bikino', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','bikino');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','admin', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','admin');
# INSERT INTO person (email,first_name, last_name,password,username) values ('admin@gmail.com','manager', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','manager');
insert into user_roles(USER_ID,ROLE_ID) values (11,1);
insert into user_roles(USER_ID,ROLE_ID) values (21,1);
insert into user_roles(USER_ID,ROLE_ID) values (13,1);
insert into user_roles(USER_ID,ROLE_ID) values (14,1);
insert into user_roles(USER_ID,ROLE_ID) values (15,2);
insert into user_roles(USER_ID,ROLE_ID) values (16,2);
insert into user_roles(USER_ID,ROLE_ID) values (17,2);
insert into USER_ROLES(USER_ID,ROLE_ID) values (18,2);
insert into USER_ROLES(USER_ID,ROLE_ID) values (19,2);
