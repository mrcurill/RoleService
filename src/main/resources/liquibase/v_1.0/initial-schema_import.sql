-- create sequence e_user_id_seq;
create table E_USER (
    id IDENTITY NOT NULL PRIMARY KEY ,--NEXTVAL('e_user_id_seq'),
    login varchar (20) NOT NULL,
    password varchar (20) NOT NULL,
    role varchar (20),
    ip varchar (20),
--     lastSign date,
--     createdAt date
);
-- insert into E_USER (login, password, createdAt) values ('admin', 'admin', timestamp);
-- insert into E_USER (login, password, createdAt) values ('guest', 'guest', timestamp);

insert into E_USER (login, password, createdAt) values ('admin', 'admin');
insert into E_USER (login, password, createdAt) values ('guest', 'guest');


--create sequence ui_config_id_seq;
create table UI_CONFIG (

    id IDENTITY NOT NULL PRIMARY KEY ,--NEXTVAL('ui_config_id_seq'),
    name varchar(50) NOT NULL
);
insert into UI_CONFIG (name) values ('view1');
insert into UI_CONFIG (name) values ('view2');


--create sequense e_component_id_seq;
create table E_COMPONENT (
    id IDENTITY NOT NULL PRIMARY KEY ,--NEXTVAL('e_component_id_seq'),
    name varchar (50) NOT NULL
);
insert into E_COMPONENT (name) values ('component1');
insert into E_COMPONENT (name) values ('component2');
insert into E_COMPONENT (name) values ('component3');
insert into E_COMPONENT (name) values ('component4');
insert into E_COMPONENT (name) values ('component5');


create table UI_CONFIG_ON_COMP (
    ui_config_id bigint not null ,
    e_component_id bigint not null,
    CONSTRAINT FK_ON_UI_CONFIG_ID FOREIGN KEY (ui_config_id) REFERENCES UIConfig (id),
    CONSTRAINT FK_ON_E_COMPONENT_ID FOREIGN KEY (e_component_id) REFERENCES EComponent (id)
);
insert into UI_CONFIG_ON_COMP (ui_config_id,e_component_id) values (1,1);
insert into UI_CONFIG_ON_COMP (ui_config_id,e_component_id) values (1,2);
insert into UI_CONFIG_ON_COMP (ui_config_id,e_component_id) values (2,1);


create table UI_CONFIG_OFF_COMP (
    ui_config_id bigint not null,
    e_component_id bigint not null,
    CONSTRAINT FK_OFF_UI_CONFIG_ID FOREIGN KEY (ui_config_id) REFERENCES UIConfig (id),
    CONSTRAINT FK_OFF_E_COMPONENT_ID FOREIGN KEY (e_component_id) REFERENCES EComponent (id)
);
insert into UI_CONFIG_OFF_COMP (ui_config_id,e_component_id) values (1,3);
insert into UI_CONFIG_OFF_COMP (ui_config_id,e_component_id) values (1,4);
insert into UI_CONFIG_OFF_COMP (ui_config_id,e_component_id) values (2,3);


create table UI_CONFIG_DISABLED_COMP (
    ui_config_id bigint not null,
    e_component_id bigint not null,
    CONSTRAINT FK_DISABLED_UI_CONFIG_ID FOREIGN KEY (ui_config_id) REFERENCES UIConfig (id),
    CONSTRAINT FK_DISABLED_E_COMPONENT_ID FOREIGN KEY (e_component_id) REFERENCES EComponent (id)
);
insert into UI_CONFIG_DISABLED_COMP (ui_config_id,e_component_id) values (1,5);
insert into UI_CONFIG_DISABLED_COMP (ui_config_id,e_component_id) values (2,4);
insert into UI_CONFIG_DISABLED_COMP (ui_config_id,e_component_id) values (2,5);