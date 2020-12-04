create database database_design;
use database_design;
create table customer(
customerId int not null unique auto_increment,
customerName varchar(50) not null,
phoneNumber varchar(10) not null,
address varchar(50) not null,
creditLimit double, 
constraint customer_pk primary key (customerId)
);
create table product(
productCode int not null unique auto_increment,
productName varchar(40) not null,
vendor varchar (30) not null,
productDescription text not null,
quantityInStock double not null,
purchasePrice double not null,
salesPrice double not null,
constraint product_pk primary key (productCode)
);
create table orders(
orderNumber int not null auto_increment,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
customerNumber int not null,
price double not null,
orderStatus varchar(15) not null,
constraint orders_pk primary key (orderNumber),
foreign key (customerNumber) references customer(customerId)
);
create table oderProduct(
orderNumber int not null,
productCode int not null,
foreign key (orderNumber) references orders(orderNumber),
foreign key (productCode) references product(productCode),
constraint orderProduct_pk primary key (orderNumber, productCode)
);

create table payments(
customerNumber int not null auto_increment,
checkNumber varchar(50) not null,
paymentDate date not null,
amount double not null,
constraint payments_pk primary key (checkNumber),
foreign key (customerNumber) references customer(customerId)
);
create table productLines(
productLine varchar(50) not null,
textDescription text,
image varchar(50)
);
create table offices(
officeCode varchar(10) not null,
city varchar(50) not null,
phone varchar(50) not null,
address varchar(50) not null,
country varchar(50) not null,
postalCode varchar(50) not null
);
create table employees(
employeeNumber int not null auto_increment,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitile varchar(50) not null,
constraint employee_pk primary key (employeeNumber)
);
alter table customer
add salesRepEmployeeNumber int not null,
add foreign key (salesRepEmployeeNumber) references employees(employeeNumber);
alter table productLines
add constraint productLine_pk primary key (productLine);
alter table product
add productLine varchar(50) not null,
add foreign key (productLine) references productlines(productLine);
alter table employees
add reportTo int not null,
add foreign key (reportTo) references employees(employeeNumber);
alter table offices
add constraint office_pk primary key (officeCode);
alter table employees
add officeCode varchar(10) not null,
add foreign key (officeCode) references offices(officeCode);





