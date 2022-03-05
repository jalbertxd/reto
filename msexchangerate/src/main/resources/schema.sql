DROP TABLE IF EXISTS tipo_cambio;  
CREATE TABLE tipo_cambio (  
id INT AUTO_INCREMENT PRIMARY KEY,  
moneda_origen VARCHAR(10) NOT NULL,  
moneda_destino VARCHAR(10) NOT NULL,
tipo_cambio FLOAT NOT NULL,
operador VARCHAR(10) NOT NULL
);
