drop procedure if exists getSummeryByCity;
delimiter //
CREATE PROCEDURE getSummeryByCity()
BEGIN
	SELECT customers.city as City, count(customers.CustomerID) as Total_Customers from Customers group by customers.city;
end //
delimiter ;

drop procedure if exists getSummeryByCountry;
delimiter //
CREATE PROCEDURE getSummeryByCountry()
BEGIN
	SELECT customers.country as Country, count(customers.CustomerID) as Total_Customers from Customers group by customers.Country;
end //
delimiter ;