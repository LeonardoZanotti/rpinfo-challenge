INSERT INTO client (name, address, phone, email) VALUES 
('John Doe', '123 Elm Street', '555-1234', 'john.doe@example.com'),
('Jane Smith', '456 Oak Avenue', '555-5678', 'jane.smith@example.com');

INSERT INTO equipment (type, brand) VALUES 
('Printer', 'HP'),
('Laptop', 'Dell');

INSERT INTO service_order (client_id, equipment_id, description, pending, started) VALUES 
(1, 1, 'Fix the printer', 0, 1),
(2, 2, 'The Laptop is broken', 1, 1);

INSERT INTO tracking (description, service_order_id) VALUES 
('Buying new tools to fix t he printer', 1),
('We bought the tools and we are going to fix it by tomorrow', 1),
('Fixed! We are marking this as concluded.', 1),
('Laptop needs replacement', 2);