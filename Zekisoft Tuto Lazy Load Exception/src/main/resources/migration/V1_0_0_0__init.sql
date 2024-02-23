create table author (id bigint not null, name varchar(255), primary key (id));
create table book (author_id bigint not null, id bigint not null, title varchar(255), primary key (id));
alter table if exists book add constraint FKklnrv3weler2ftkweewlky958 foreign key (author_id) references author;
