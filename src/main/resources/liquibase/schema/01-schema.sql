--liquibase formatted sql

--changeset rfatnev:v01
create table resource
(
    id   uuid not null primary key,
    data varchar(256)
)