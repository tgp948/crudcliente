CREATE SCHEMA `dbcrudcliente` ;

CREATE TABLE `dbcrudcliente`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `datnasc` DATE NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `estcivil` VARCHAR(45) NOT NULL,
  `ativo` INT NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idcliente`));
