create table customers
(
    id             int            not null primary key default unique_rowid(),
    name           varchar(25)    not null,
    middlename     varchar(25) null,
    lastname       varchar(25) null,
    becamecustomer date null
);
create table accounts
(
    id         int            not null primary key default unique_rowid(),
    balance    numeric(19, 2) not null,
    type       varchar(25)    not null,
    customerid int not null,
    CONSTRAINT fk_customer FOREIGN KEY (customerid) references customers
);