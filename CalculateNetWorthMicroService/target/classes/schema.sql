create table portfolio (
portfolio_Id int primary key);

create table asset (
tid int primary key,
assetName varchar(20),
portfolioId int,
type varchar(10),
units int, 
foreign key(portfolioId) references portfolio(portfolio_Id)
);