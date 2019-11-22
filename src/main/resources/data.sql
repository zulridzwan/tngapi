DROP TABLE  IF EXISTS SampleCustomer;

CREATE TABLE SampleCustomer (
   recid bigint auto_increment, 
   tagid Varchar(36),
   customername VARCHAR(50),
   createddate DATE
);
