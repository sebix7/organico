-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-07-2021 a las 15:13:21
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carro`
--

CREATE TABLE `carro` (
  `id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combo`
--

CREATE TABLE `combo` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `distancia` double DEFAULT NULL,
  `estacion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `tieneDescuento` bit(1) DEFAULT NULL,
  `vencimiento` datetime(6) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `combo`
--

INSERT INTO `combo` (`id`, `descripcion`, `distancia`, `estacion`, `imagen`, `latitud`, `longitud`, `nombre`, `peso`, `precio`, `stock`, `tieneDescuento`, `vencimiento`, `usuario_id`) VALUES
(1, 'papas,batatas,cebollas', NULL, 'Verano', NULL, -34.692289, -58.560121, 'Combo Verano1', 5000, 500, 5, b'0', NULL, 1),
(2, 'Algunas cosas', NULL, 'Verano', NULL, -34.692289, -58.560121, 'Combo Prueba', 2000, 650, 5, b'0', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combocarro`
--

CREATE TABLE `combocarro` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `carro_id` bigint(20) DEFAULT NULL,
  `combo_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL,
  `entrega` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fechaDeEmision` datetime(6) DEFAULT NULL,
  `carro_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `email`, `nombre`, `password`, `rol`) VALUES
(1, b'1', 'vendedor1@vendedor.com', 'Mariano Benitez', '123', 'Vendedor'),
(2, b'1', 'vendedor2@vendedor.com', 'Sabrina Martinez', '123', 'Vendedor'),
(3, b'1', 'vendedor3@vendedor.com', 'Claudio Garcia', '123', 'Vendedor'),
(4, b'1', 'cliente@cliente.com', 'Mauro Zarate', '123', 'Cliente'),
(5, b'1', 'cliente2@cliente.com', 'Daniel Lopez', '123', 'Cliente'),
(6, b'1', 'cliente3@cliente.com', 'Marcela Peralta', '123', 'Cliente'),
(7, b'1', 'administrador@administrador.com', 'Juan Admin', '123', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valorarcombo`
--

CREATE TABLE `valorarcombo` (
  `id` bigint(20) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `leido` bit(1) NOT NULL,
  `valoracion` bit(1) NOT NULL,
  `idCombo` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh5c6ea8th5l1el1l97396bx29` (`usuario_id`);

--
-- Indices de la tabla `combo`
--
ALTER TABLE `combo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4ntebx2d1erkhoponrfgr88qd` (`usuario_id`);

--
-- Indices de la tabla `combocarro`
--
ALTER TABLE `combocarro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe7jcpe5eewhwokx022c8w4jnk` (`carro_id`),
  ADD KEY `FKaddg7cy1bhkdk0ktpcpk0enj2` (`combo_id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7x4rd3ajnx51a0eyp4ug28pbn` (`carro_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `valorarcombo`
--
ALTER TABLE `valorarcombo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5mynndt508caselsjupmedvb4` (`idCombo`),
  ADD KEY `FK98jpjs4xekcmqekx6wx1aav9c` (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carro`
--
ALTER TABLE `carro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `combo`
--
ALTER TABLE `combo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `combocarro`
--
ALTER TABLE `combocarro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `valorarcombo`
--
ALTER TABLE `valorarcombo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carro`
--
ALTER TABLE `carro`
  ADD CONSTRAINT `FKh5c6ea8th5l1el1l97396bx29` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `combo`
--
ALTER TABLE `combo`
  ADD CONSTRAINT `FK4ntebx2d1erkhoponrfgr88qd` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `combocarro`
--
ALTER TABLE `combocarro`
  ADD CONSTRAINT `FKaddg7cy1bhkdk0ktpcpk0enj2` FOREIGN KEY (`combo_id`) REFERENCES `combo` (`id`),
  ADD CONSTRAINT `FKe7jcpe5eewhwokx022c8w4jnk` FOREIGN KEY (`carro_id`) REFERENCES `carro` (`id`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK7x4rd3ajnx51a0eyp4ug28pbn` FOREIGN KEY (`carro_id`) REFERENCES `carro` (`id`);

--
-- Filtros para la tabla `valorarcombo`
--
ALTER TABLE `valorarcombo`
  ADD CONSTRAINT `FK5mynndt508caselsjupmedvb4` FOREIGN KEY (`idCombo`) REFERENCES `combo` (`id`),
  ADD CONSTRAINT `FK98jpjs4xekcmqekx6wx1aav9c` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
