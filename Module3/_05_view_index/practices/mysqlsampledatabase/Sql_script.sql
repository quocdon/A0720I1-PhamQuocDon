use classicmodels;
explain select * from customers where country = 'USA';
alter table customers
add index idx_country (country);
explain select * from customers where country = 'USA';
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
alter table customers
add index idx_name (contactFirstName, contactLastName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
alter table customers
drop index idx_name;
create view customerViews as
select CustomerNumber, customerName from customers;
create view addressOfCustomerViews as
select  customerviews.customerNumber, customerviews.customerName, customers.city from customerviews 
left join customers on  customerviews.customerNumber = customers.customerNumber;
drop view addressofcustomerviews;