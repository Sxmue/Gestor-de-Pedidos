Create Database GestorPedidos;
use gestorpedidos;
create table Usuario(
ID int primary key auto_increment not null,
nombre varchar(15) not null,
pass varchar(255) not null,
email varchar(255) not null
);

create table Producto(
id int primary key auto_increment not null,
nombre varchar(50) not null,
precio dec(10,2) not null,
 cantidad int not null
)AUTO_INCREMENT=100;

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(7) NOT NULL,
    fecha DATE NOT NULL,
    usuario_id INT,
    total DECIMAL(10, 2) NOT NULL,
    INDEX (codigo),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

CREATE TABLE Item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigoPedido VARCHAR(7) NOT NULL,
    cantidad INT NOT NULL,
    idProducto INT,
    FOREIGN KEY (codigoPedido) REFERENCES Pedido(codigo),
    FOREIGN KEY (idProducto) REFERENCES Producto(id)
);

INSERT INTO Usuario (nombre, pass, email) VALUES ('Usuario1', 'contraseña123', 'usuario1@example.com');
INSERT INTO Usuario (nombre, pass, email) VALUES ('Usuario2', 'password456', 'usuario2@example.com');
INSERT INTO Usuario (nombre, pass, email) VALUES ('Usuario3', 'securepass789', 'usuario3@example.com');

INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Smartphone Samsung Galaxy S22', 799.99, 15);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Laptop Dell XPS 15', 1499.99, 10);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('PlayStation 5 Pro', 599.99, 8);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Apple iPad Pro', 899.00, 12);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Smartwatch Apple Watch Series 7', 399.50, 20);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Wireless Earbuds Sony WF-1000XM4', 249.99, 30);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Gaming Mouse Logitech G Pro X', 89.99, 50);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('4K Ultra HD TV LG OLED CX', 1299.99, 18);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Nintendo Switch OLED Model', 349.00, 25);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Smart Home Speaker Amazon Echo', 99.95, 40);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Bluetooth Keyboard Logitech K811', 79.99, 35);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Portable External SSD Samsung T7', 199.99, 22);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Wireless Router ASUS RT-AX86U', 179.95, 28);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Nvidia GeForce RTX 3080', 699.99, 15);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Smart Thermostat Google Nest', 249.00, 20);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Bluetooth Soundbar Sony HT-X9000F', 399.99, 12);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('DJI Mavic Air 2 Drone', 799.00, 7);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Fitness Tracker Fitbit Charge 5', 149.95, 30);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('GoPro Hero 10 Black', 499.99, 9);
INSERT INTO Producto (nombre, precio, cantidad) VALUES ('Desktop Gaming PC Alienware Aurora', 1999.99, 5);



-- Pedidos para Usuario1 
INSERT INTO Pedido (codigo, usuario_id, fecha, total) VALUES ('PED-001', 1, '2022-09-10', 2298.97);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-001', 2, 101);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-001', 1, 103);

INSERT INTO Pedido (codigo, usuario_id, fecha, total) VALUES ('PED-002', 1, '2023-03-05', 1799.48);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-002', 3, 104);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-002', 1, 106);

-- Pedidos para Usuario2 
INSERT INTO Pedido (codigo, usuario_id, fecha, total) VALUES ('PED-003', 2, '2021-12-20', 799.00);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-003', 2, 105);

INSERT INTO Pedido (codigo, usuario_id, fecha, total) VALUES ('PED-004', 2, '2022-09-05', 1799.47);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-004', 1, 102);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-004', 3, 107);

-- Pedidos para Usuario3
INSERT INTO Pedido (codigo, usuario_id, fecha, total) VALUES ('PED-005', 3, '2020-11-14', 299.90);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-005', 2, 109);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-005', 1, 110);

INSERT INTO Pedido (codigo, usuario_id, fecha, total) VALUES ('PED-006', 3, '2021-03-30', 729.96);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-006', 3, 111);
INSERT INTO Item (codigoPedido, cantidad, idProducto) VALUES ('PED-006', 2, 113);

