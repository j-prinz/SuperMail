INSERT INTO Employee
  VALUES (1111, 'Jessica', 4454019173);
INSERT INTO Employee
  VALUES (2222, 'Sarah', 5556667777);
INSERT INTO Employee
  VALUES (3333, 'Thomas', 5556887115);
INSERT INTO Employee
  VALUES (4444, 'Frank', 4455889966);
INSERT INTO Employee
  VALUES (5555, 'Jamie', 5978883125);

INSERT INTO EmployeeWorkArea
  VALUES (1111, 'Vancouver');
INSERT INTO EmployeeWorkArea
  VALUES (2222, 'Burnaby');
INSERT INTO EmployeeWorkArea
  VALUES (3333, 'Whistler');
INSERT INTO EmployeeWorkArea
  VALUES (4444, 'Surrey');
INSERT INTO EmployeeWorkArea
  VALUES (5555, 'Richmond');

INSERT INTO PostOfficeDetails
  VALUES (91, 'UBC', 'Vancouver');
INSERT INTO PostOfficeDetails
  VALUES (92, 'SFU', 'Burnaby');
INSERT INTO PostOfficeDetails
  VALUES (93, 'Guildford', 'Surrey');
INSERT INTO PostOfficeDetails
  VALUES (94, 'Whistler Village', 'Whistler');
INSERT INTO PostOfficeDetails
  VALUES (95, 'Brighouse', 'Richmond');

INSERT INTO AreaServicedByPO
  VALUES (91,'Vancouver');
INSERT INTO AreaServicedByPO
  VALUES (92,'Burnaby');
INSERT INTO AreaServicedByPO
  VALUES (93,'Surrey');
INSERT INTO AreaServicedByPO
  VALUES (94,'Whistler');
INSERT INTO AreaServicedByPO
  VALUES (95,'Richmond');

INSERT INTO MailboxServicedBy
  VALUES (1000, 91);
INSERT INTO MailboxServicedBy
  VALUES (2000, 92);
INSERT INTO MailboxServicedBy
  VALUES (3000, 93);
INSERT INTO MailboxServicedBy
  VALUES (4000, 94);
INSERT INTO MailboxServicedBy
  VALUES (5000, 95);

INSERT INTO Customer
  VALUES (101, 'Alicia', 6135530195, '451 East Mall, Vancouver, BC');
INSERT INTO Customer
  VALUES (102, 'Ryan', 6135589195, '4256 Main Mall, Richmond, BC');
INSERT INTO Customer
  VALUES (103, 'Jamie', 6144530195, '46 West Mall, Burnaby, BC');
INSERT INTO Customer
  VALUES (104, 'Jessica', 6135533695, '1 Whistler Mountain Rd, Whistler, BC');
INSERT INTO Customer
  VALUES (105, 'Andrew', 6155555195, '453 East Mall, Surrey, BC');

INSERT INTO Receiver
  VALUES (111, 'Travis', '33 Kerr St, Vancouver, BC', 'v4a2w2');
INSERT INTO Receiver
  VALUES (112, 'Paul', '456 Guildford Ave, Surrey, BC', 'p2r3r3');
INSERT INTO Receiver
  VALUES (113, 'Samantha', '22 Blackcomb Blvd, Whistler, BC', 'd6w4d3');
INSERT INTO Receiver
  VALUES (114, 'Bonnie', '570 Simon Fraser Ave, Burnaby, BC', '8da3f5');
INSERT INTO Receiver
  VALUES (115, 'Tam', '456 Brighouse Ave, Richmond, BC', '5j63f2');

INSERT INTO DeliveryOrder
  VALUES (001, 101, 3333, '20-FEB-2020', 'high', 'delivered', 6.99, 112);
INSERT INTO DeliveryOrder
  VALUES (002, 102, 5555, '01-MAY-2020', 'low', 'enroute', 53.99, 113);
INSERT INTO DeliveryOrder
  VALUES (003, 103, 4444, '20-JAN-2020', 'medium', 'delivered', 58.00, 114);
INSERT INTO DeliveryOrder
  VALUES (004, 104, 1111, '28-MAR-2020', 'high', 'delivered', 288.43, 115);
INSERT INTO DeliveryOrder
  VALUES (005, 105, 2222, '08-FEB-2020', 'high', 'enroute', 6.99, 111);

INSERT INTO Items
  VALUES (1, 001, 1, 2, 3, 1, 'TRUE');
INSERT INTO Items
  VALUES (2, 002, 2, 2, 3, 1, 'FALSE');
INSERT INTO Items
  VALUES (3, 003, 22, 4, 2, 1, 'TRUE');
INSERT INTO Items
  VALUES (4, 002, 11, 4, 2, 1, 'FALSE');
INSERT INTO Items
  VALUES (5, 002, 5, 6, 7, 1, 'FALSE');
INSERT INTO Items
  VALUES (6, 004, 1, 5, 3, 1, 'FALSE');
INSERT INTO Items
  VALUES (7, 005, 3, 2, 4, 1, 'TRUE');
INSERT INTO Items
  VALUES (8, 005, 2, 2, 2, 1, 'TRUE');
