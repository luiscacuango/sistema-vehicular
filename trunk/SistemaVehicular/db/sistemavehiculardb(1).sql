-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-02-2015 a las 22:40:28
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sistemavehiculardb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE IF NOT EXISTS `ciudad` (
`COD_CIUDAD` int(11) NOT NULL,
  `NOM_CIUDAD` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`COD_CIUDAD`, `NOM_CIUDAD`) VALUES
(1, 'Cuencaa'),
(2, 'La Concordia'),
(3, 'Guayaquil'),
(4, 'Quevedo'),
(5, 'Esmeraldas'),
(6, 'Santo Domingo'),
(7, 'Manta'),
(8, 'Sua'),
(9, 'Atacames'),
(10, 'Salinas'),
(11, 'Guaranda'),
(12, 'San Lorenzo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_ruta`
--

CREATE TABLE IF NOT EXISTS `control_ruta` (
`ID_RUTA` int(11) NOT NULL,
  `ID_ORDEMOVI` int(11) DEFAULT NULL,
  `COD_CIUDAD` int(11) DEFAULT NULL,
  `DESCRI_RUTA` varchar(100) DEFAULT NULL,
  `ESTADO_RUTA` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `control_ruta`
--

INSERT INTO `control_ruta` (`ID_RUTA`, `ID_ORDEMOVI`, `COD_CIUDAD`, `DESCRI_RUTA`, `ESTADO_RUTA`) VALUES
(1, 1, 7, '2015-MANTA-SALINAS1', 'a'),
(2, 1, 3, '2015-MANTA-SALINAS2', 'a'),
(3, 1, 10, '2015-MANTA-SALINAS3', 'a');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE IF NOT EXISTS `departamento` (
`ID_DPTO` int(11) NOT NULL,
  `ID_EMPRESA` int(11) NOT NULL,
  `NOMB_DPTO` varchar(100) NOT NULL,
  `SIGL_DPTO` varchar(10) DEFAULT NULL,
  `ESTA_DPTO` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`ID_DPTO`, `ID_EMPRESA`, `NOMB_DPTO`, `SIGL_DPTO`, `ESTA_DPTO`) VALUES
(1, 1, 'Gerencial', 'Ge', 'A'),
(2, 1, 'Presidencial', 'Pr', 'A'),
(3, 1, 'Vicepresidencial', 'Vi', 'A'),
(4, 1, 'Operativo', 'Op', 'A'),
(5, 1, 'Ventas', 'Ve', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
`ID_EMPL` int(11) NOT NULL,
  `ID_TIPOEMPL` int(11) NOT NULL,
  `ID_DPTO` int(11) NOT NULL,
  `CEDU_EMPL` varchar(15) NOT NULL,
  `NOMB_EMPL` varchar(100) NOT NULL,
  `APEL_EMPL` varchar(100) NOT NULL,
  `TELE_EMPL` varchar(10) DEFAULT NULL,
  `DIRE_EMPL` varchar(200) DEFAULT NULL,
  `GENE_EMPL` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID_EMPL`, `ID_TIPOEMPL`, `ID_DPTO`, `CEDU_EMPL`, `NOMB_EMPL`, `APEL_EMPL`, `TELE_EMPL`, `DIRE_EMPL`, `GENE_EMPL`) VALUES
(1, 2, 1, '1234567890', 'Pedro', 'Escobar', '0987654321', 'Esmeraldas', 'M'),
(2, 1, 5, '6789023456', 'Martina', 'Cascabel', '0934567889', 'Guaranda', 'F');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
`ID_EMPRESA` int(11) NOT NULL,
  `NOMB_EMPR` varchar(100) NOT NULL,
  `SIGL_EMPR` varchar(10) DEFAULT NULL,
  `DIRE_EMPR` varchar(200) DEFAULT NULL,
  `TELF_EMPR` varchar(10) DEFAULT NULL,
  `EST_EMPR` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`ID_EMPRESA`, `NOMB_EMPR`, `SIGL_EMPR`, `DIRE_EMPR`, `TELF_EMPR`, `EST_EMPR`) VALUES
(1, 'Tres Patitos', '3P', 'Nose', 'no hay', 'A'),
(2, 'Agil Express', 'AE', 'La Colón', '092345667', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_movilizacion`
--

CREATE TABLE IF NOT EXISTS `orden_movilizacion` (
`ID_ORDEMOVI` int(11) NOT NULL,
  `ID_EMPL` int(11) DEFAULT NULL,
  `ID_VEHI` int(11) DEFAULT NULL,
  `EMP_ID_EMPL` int(11) DEFAULT NULL,
  `FECHSOLI_ORDEMOVI` datetime NOT NULL,
  `ESTADO_SOLI_ORDEMOVI` varchar(1) DEFAULT NULL,
  `FECINI_ORDEMOVI` datetime DEFAULT NULL,
  `FECFIN_ORDEMOVI` datetime DEFAULT NULL,
  `OBSER_ORDEMOVI` varchar(100) DEFAULT NULL,
  `ESTADO_ORDEMOVI` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `orden_movilizacion`
--

INSERT INTO `orden_movilizacion` (`ID_ORDEMOVI`, `ID_EMPL`, `ID_VEHI`, `EMP_ID_EMPL`, `FECHSOLI_ORDEMOVI`, `ESTADO_SOLI_ORDEMOVI`, `FECINI_ORDEMOVI`, `FECFIN_ORDEMOVI`, `OBSER_ORDEMOVI`, `ESTADO_ORDEMOVI`) VALUES
(1, 1, 1, NULL, '2015-02-04 07:30:15', 'I', '2015-02-06 08:00:00', '2015-02-08 14:00:00', NULL, 'P'),
(2, 2, 2, NULL, '2015-02-05 10:11:32', 'I', '2015-02-20 05:00:00', '2015-02-23 17:00:00', NULL, 'P');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_empleado`
--

CREATE TABLE IF NOT EXISTS `tipo_empleado` (
`ID_TIPOEMPL` int(11) NOT NULL,
  `DESCRI_TIPOEMPL` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_empleado`
--

INSERT INTO `tipo_empleado` (`ID_TIPOEMPL`, `DESCRI_TIPOEMPL`) VALUES
(1, 'Emple Administrativo'),
(2, 'Emple Gerencial'),
(3, 'Emple Conductor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculo`
--

CREATE TABLE IF NOT EXISTS `tipo_vehiculo` (
`ID_TIPOVEHI` int(11) NOT NULL,
  `DESCRI_TIPOVEHI` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_vehiculo`
--

INSERT INTO `tipo_vehiculo` (`ID_TIPOVEHI`, `DESCRI_TIPOVEHI`) VALUES
(1, 'Camion'),
(2, 'Bolqueta'),
(3, 'Furgoneta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`ID_USUARIO` int(11) NOT NULL,
  `LOGIN_USUARIO` varchar(20) NOT NULL,
  `PASSWORD_USUARIO` varchar(20) NOT NULL,
  `ESTADO_USUARIO` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `LOGIN_USUARIO`, `PASSWORD_USUARIO`, `ESTADO_USUARIO`) VALUES
(1, 'admin', 'admin', 'A'),
(2, 'usuario1', 'usuario1', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE IF NOT EXISTS `vehiculo` (
`ID_VEHI` int(11) NOT NULL,
  `ID_TIPOVEHI` int(11) NOT NULL,
  `MOTOR_VEHI` varchar(30) NOT NULL,
  `MARCA_VEHI` varchar(30) NOT NULL,
  `MATRI_VEHI` varchar(30) DEFAULT NULL,
  `CHASIS_VEHI` varchar(50) DEFAULT NULL,
  `PLACA_VEHI` varchar(10) DEFAULT NULL,
  `COLOR_VEHI` varchar(30) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`ID_VEHI`, `ID_TIPOVEHI`, `MOTOR_VEHI`, `MARCA_VEHI`, `MATRI_VEHI`, `CHASIS_VEHI`, `PLACA_VEHI`, `COLOR_VEHI`) VALUES
(1, 2, '23456789ERTYU', 'VOLKSWAGEN', 'T5678RT567', '23456ERTY34567', 'PBA0876', 'Amarillo'),
(2, 1, '987654UYTRE8765', 'CHEROQUE', 'RT567ERT3456', 'TY56GH567FGH567', 'PBC9876', 'Azul');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
 ADD PRIMARY KEY (`COD_CIUDAD`);

--
-- Indices de la tabla `control_ruta`
--
ALTER TABLE `control_ruta`
 ADD PRIMARY KEY (`ID_RUTA`), ADD KEY `FK_CIUDAD_RUTA` (`COD_CIUDAD`), ADD KEY `FK_ORDEMOVI_CONTRUTA` (`ID_ORDEMOVI`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
 ADD PRIMARY KEY (`ID_DPTO`), ADD KEY `FK_EMPR_DPTO` (`ID_EMPRESA`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
 ADD PRIMARY KEY (`ID_EMPL`), ADD KEY `FK_DPTO_EMPL` (`ID_DPTO`), ADD KEY `FK_TIPOEMPL_EMPL` (`ID_TIPOEMPL`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
 ADD PRIMARY KEY (`ID_EMPRESA`);

--
-- Indices de la tabla `orden_movilizacion`
--
ALTER TABLE `orden_movilizacion`
 ADD PRIMARY KEY (`ID_ORDEMOVI`), ADD KEY `FK_EMPL_APRUEBA` (`ID_EMPL`), ADD KEY `FK_EMPL_SOLICITA` (`EMP_ID_EMPL`), ADD KEY `FK_VEHI_ORDEMOVI` (`ID_VEHI`);

--
-- Indices de la tabla `tipo_empleado`
--
ALTER TABLE `tipo_empleado`
 ADD PRIMARY KEY (`ID_TIPOEMPL`);

--
-- Indices de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
 ADD PRIMARY KEY (`ID_TIPOVEHI`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`ID_USUARIO`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
 ADD PRIMARY KEY (`ID_VEHI`), ADD KEY `FK_TIPOVEHI_VEHI` (`ID_TIPOVEHI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
MODIFY `COD_CIUDAD` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `control_ruta`
--
ALTER TABLE `control_ruta`
MODIFY `ID_RUTA` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
MODIFY `ID_DPTO` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
MODIFY `ID_EMPL` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
MODIFY `ID_EMPRESA` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `orden_movilizacion`
--
ALTER TABLE `orden_movilizacion`
MODIFY `ID_ORDEMOVI` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tipo_empleado`
--
ALTER TABLE `tipo_empleado`
MODIFY `ID_TIPOEMPL` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
MODIFY `ID_TIPOVEHI` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
MODIFY `ID_VEHI` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `control_ruta`
--
ALTER TABLE `control_ruta`
ADD CONSTRAINT `FK_CIUDAD_RUTA` FOREIGN KEY (`COD_CIUDAD`) REFERENCES `ciudad` (`COD_CIUDAD`),
ADD CONSTRAINT `FK_ORDEMOVI_CONTRUTA` FOREIGN KEY (`ID_ORDEMOVI`) REFERENCES `orden_movilizacion` (`ID_ORDEMOVI`);

--
-- Filtros para la tabla `departamento`
--
ALTER TABLE `departamento`
ADD CONSTRAINT `FK_EMPR_DPTO` FOREIGN KEY (`ID_EMPRESA`) REFERENCES `empresa` (`ID_EMPRESA`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
ADD CONSTRAINT `FK_DPTO_EMPL` FOREIGN KEY (`ID_DPTO`) REFERENCES `departamento` (`ID_DPTO`),
ADD CONSTRAINT `FK_TIPOEMPL_EMPL` FOREIGN KEY (`ID_TIPOEMPL`) REFERENCES `tipo_empleado` (`ID_TIPOEMPL`);

--
-- Filtros para la tabla `orden_movilizacion`
--
ALTER TABLE `orden_movilizacion`
ADD CONSTRAINT `FK_EMPL_APRUEBA` FOREIGN KEY (`ID_EMPL`) REFERENCES `empleado` (`ID_EMPL`),
ADD CONSTRAINT `FK_EMPL_SOLICITA` FOREIGN KEY (`EMP_ID_EMPL`) REFERENCES `empleado` (`ID_EMPL`),
ADD CONSTRAINT `FK_VEHI_ORDEMOVI` FOREIGN KEY (`ID_VEHI`) REFERENCES `vehiculo` (`ID_VEHI`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
ADD CONSTRAINT `FK_TIPOVEHI_VEHI` FOREIGN KEY (`ID_TIPOVEHI`) REFERENCES `tipo_vehiculo` (`ID_TIPOVEHI`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
