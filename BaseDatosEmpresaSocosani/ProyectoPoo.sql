drop database BaseDatosSocosani;

CREATE DATABASE BaseDatosSocosani;
GO
USE BaseDatosSocosani;
GO

CREATE TABLE modeloPersona (
    iD INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    DNI INT UNIQUE NOT NULL,
    direccion NVARCHAR(100),
    telefono INT,
    correo VARCHAR(255) UNIQUE
);


CREATE TABLE modeloCliente (
    iDCliente INT PRIMARY KEY,
    iD INT,
    Ruc INT UNIQUE NOT NULL,
    FOREIGN KEY (iD) REFERENCES modeloPersona(iD)
);

CREATE TABLE modeloUsuario (
    iDUsuario INT PRIMARY KEY,
    iD INT,
    contrasena VARCHAR(255) NOT NULL,
    FOREIGN KEY (iD) REFERENCES modeloPersona(iD)
);

CREATE TABLE modeloFuncionario (
    iDFuncionario INT PRIMARY KEY,
    iD INT,
    puesto VARCHAR(100) NOT NULL,
    FOREIGN KEY (iD) REFERENCES modeloPersona(iD)
);

CREATE TABLE modeloProducto (
    iDProducto INT PRIMARY KEY IDENTITY(1,1),
    marca VARCHAR(100) NOT NULL,
    volumen FLOAT NOT NULL,
    precio FLOAT NOT NULL,
    sabor VARCHAR(100) NOT NULL
);

CREATE TABLE modeloPedido (
    iDPedido INT PRIMARY KEY IDENTITY(1,1),
    cantidad INT NOT NULL,
    fecha DATE NOT NULL,
    iDCliente INT,
    iDProducto INT,
    FOREIGN KEY (iDCliente) REFERENCES modeloCliente(iDCliente),
    FOREIGN KEY (iDProducto) REFERENCES modeloProducto(iDProducto)
);

CREATE TABLE modeloCompra (
    iDCompra INT PRIMARY KEY IDENTITY(1,1),
    iDCliente INT,
    iDProducto INT,
    iDFuncionario INT,
    FOREIGN KEY (iDCliente) REFERENCES modeloCliente(iDCliente),
    FOREIGN KEY (iDProducto) REFERENCES modeloProducto(iDProducto),
    FOREIGN KEY (iDFuncionario) REFERENCES modeloFuncionario(iDFuncionario)
);




delete *from where 
CREATE VIEW vistaDatosCompletos AS
SELECT 
    p.iD, 
    p.nombre, 
    p.apellido, 
    p.DNI, 
    p.direccion, 
    p.telefono, 
    p.correo, 
    c.iDCliente, 
    c.Ruc, 
    u.iDUsuario, 
    u.contrasena
FROM 
    modeloPersona p
JOIN 
    modeloCliente c ON p.iD = c.iD
JOIN 
    modeloUsuario u ON p.iD = u.iD;


select*from modeloUsuario
SELECT * FROM vistaDatosCompletos;




