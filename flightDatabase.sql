create database flightDatabase;
use flightDatabase;
create table flight(Name varchar(15) not null, Source varchar(30) ,
Destination varchar(15) ,Date varchar(15) ,Time varchar(15),Passport_ID varchar(20),
ConfirmPassport_ID varchar(20) ,Mobile_no integer(12),
EMAIL varchar(30) );