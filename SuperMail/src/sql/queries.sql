-- Insert Operation: Creating a new Order
-- DeliveryOrder(Order_ID,Customer_ID,EID,INITIAL_DATE,PRIORITY,DELIVERY_STATUS,PRICING,RECEIVER_ID)

INSERT INTO DeliveryOrder
VALUES (?,?,?,?,?,?,?,?);

-- Delete Operation: Deleting an Employee (cascades to EmployeeWorkArea)
-- Employee (EID)

DELETE FROM Employee e
WHERE e.EID = ?;

-- Update Operation: Update DELIVERY_STATUS of a DeliveryOrder
-- DeliveryOrder(DELIVERY_STATUS)

UPDATE DeliveryOrder d
SET DELIVERY_STATUS = ?
WHERE d.Order_ID = ?;

-- Selection Operation: Names of Customers with the same address
-- Customer(Customer_ID,Customer_Address)

-- SELECT c1.Customer_ID AS "id1", c
-- FROM Customer c1, Customer c2
-- WHERE c1.Customer_Address = c2.Customer_Address
