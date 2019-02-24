/*
Navicat MySQL Data Transfer

Source Server         : MySQL_Local
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : agencia

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2016-09-26 23:40:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `automovil`
-- ----------------------------
DROP TABLE IF EXISTS `automovil`;
CREATE TABLE `automovil` (
  `nomotor` int(11) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `anio` int(11) NOT NULL,
  `idmarca` int(11) NOT NULL,
  `fechaensamble` date DEFAULT NULL,
  `precioventa` float NOT NULL,
  `idclase` int(11) NOT NULL,
  PRIMARY KEY (`nomotor`),
  KEY `fk_automovil_1` (`idmarca`),
  KEY `fk_automovil_2` (`idclase`),
  CONSTRAINT `fk_automovil_2` FOREIGN KEY (`idclase`) REFERENCES `clase` (`IDCLASE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_automovil_1` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of automovil
-- ----------------------------

-- ----------------------------
-- Table structure for `clase`
-- ----------------------------
DROP TABLE IF EXISTS `clase`;
CREATE TABLE `clase` (
  `idclase` int(65) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idclase`),
  KEY `idclase` (`idclase`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clase
-- ----------------------------
INSERT INTO `clase` VALUES ('1', 'Deportivo');
INSERT INTO `clase` VALUES ('2', 'Estandar');
INSERT INTO `clase` VALUES ('3', 'SUV');
INSERT INTO `clase` VALUES ('4', 'Superdeportivo');

-- ----------------------------
-- Table structure for `cliente`
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fechanacimiento` date NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cliente
-- ----------------------------

-- ----------------------------
-- Table structure for `compra`
-- ----------------------------
DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `nomotor` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `fechacompra` date NOT NULL,
  PRIMARY KEY (`nomotor`,`idcliente`),
  KEY `fk_compra_2` (`idcliente`),
  CONSTRAINT `fk_compra_1` FOREIGN KEY (`nomotor`) REFERENCES `automovil` (`nomotor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_2` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of compra
-- ----------------------------

-- ----------------------------
-- Table structure for `marca`
-- ----------------------------
DROP TABLE IF EXISTS `marca`;
CREATE TABLE `marca` (
  `idmarca` int(65) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `idpais` int(65) NOT NULL,
  PRIMARY KEY (`idmarca`),
  KEY `fk_marca_1` (`idpais`),
  CONSTRAINT `fk_marca_1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`IDPAIS`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of marca
-- ----------------------------

-- ----------------------------
-- Table structure for `pais`
-- ----------------------------
DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `idpais` int(65) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pais
-- ----------------------------
