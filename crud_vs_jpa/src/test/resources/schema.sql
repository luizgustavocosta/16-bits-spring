drop table posts;
create table posts
(
    id       uuid default random_uuid() not null primary key,
    user     varchar(100),
    content  varchar(256),
    created_at TIMESTAMP WITH TIME ZONE
);