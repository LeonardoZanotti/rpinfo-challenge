INSERT INTO client (name, address, phone, email) VALUES 
('John Doe', '123 Elm Street', '555-1234', 'john.doe@example.com'),
('Jane Smith', '456 Oak Avenue', '555-5678', 'jane.smith@example.com');

INSERT INTO equipment (type, brand) VALUES 
('Printer', 'HP'),
('Laptop', 'Dell');

INSERT INTO service_order (description, pending, started) VALUES 
('Fix the printer', 0, 0),
('The Laptop is broken', 1, 1);