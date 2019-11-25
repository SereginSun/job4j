--1. Write a request to receive all products with the type "cheese".
SELECT * FROM product AS p
JOIN type AS t ON t.id = p.type_id
WHERE t.name = 'cheese';

--2. Write a request for all products that have the word "ice cream" in their name.
SELECT * FROM product
WHERE name LIKE '%ice cream%';

--3. Write a query that displays all products whose expiration date expires next month.
SELECT * FROM product
WHERE EXTRACT(MONTH FROM expired_date) = EXTRACT(MONTH FROM now()) + 1;

--4. Write a query that displays the most expensive product.
SELECT * FROM product
WHERE price = (SELECT max(price) FROM product);

--5. Write a query that displays the number of all products of a particular type.
SELECT COUNT(*) FROM product AS p
JOIN type AS t ON t.id = p.type_id
AND t.name = 'cheese';

--6. Write a request to receive all products with the type "cheese" and "milk".
SELECT * FROM product AS p
JOIN type AS t ON t.id = p.type_id
WHERE t.name IN('milk', 'cheese');

--7. Write a query that displays the type of products, which are less than 10 pieces.
SELECT DISTINCT t.name FROM type AS t 
JOIN product AS p
ON p.type_id = t.id AND p.type_id IN (
	SELECT p.type_id FROM product
	GROUP BY type_id
	HAVING count(type_id) < 10);

--8. Print all products and their type.
SELECT p.name, t.name
FROM product AS p
JOIN type AS t ON t.id = p.type_id;