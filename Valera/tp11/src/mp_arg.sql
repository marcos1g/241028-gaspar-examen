-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2024 a las 02:13:37
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mp_arg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carritos`
--

CREATE TABLE `carritos` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carritos`
--

INSERT INTO `carritos` (`id`, `nombre`, `estado`) VALUES
(1, 'Comida', 'pagado'),
(2, 'Electronica', 'no pagado'),
(3, 'Computación', 'pagado'),
(4, 'Futbol', 'no pagado'),
(5, 'Materiales', 'pagado'),
(6, 'Carpinteria', 'no pagado'),
(7, 'Metalurgia', 'pagado'),
(8, 'Limpieza', 'no pagado'),
(9, 'Vestimenta', 'pagado'),
(10, 'Muebles', 'no pagado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compradores`
--

CREATE TABLE `compradores` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compradores`
--

INSERT INTO `compradores` (`id`, `nombre`) VALUES
(1, 'Juan Pérez'),
(2, 'María López'),
(3, 'Carlos Sánchez'),
(4, 'Ana Gómez'),
(5, 'Luis Rodríguez'),
(6, 'Sofía Fernández'),
(7, 'Miguel Martínez'),
(8, 'Laura Torres'),
(9, 'Javier Díaz'),
(10, 'Isabel Ramírez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `precio`) VALUES
(1, 'Apple iPhone 13', 799.99),
(2, 'Samsung Galaxy S21', 699.99),
(3, 'Sony WH-1000XM4', 349.99),
(4, 'Dell XPS 13', 999.99),
(5, 'Apple MacBook Air', 999.99),
(6, 'HP Spectre x360', 1199.99),
(7, 'Google Pixel 6', 599.99),
(8, 'Amazon Echo Dot', 49.99),
(9, 'Nintendo Switch', 299.99),
(10, 'Sony PlayStation 5', 499.99);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_carrito`
--

CREATE TABLE `producto_carrito` (
  `id` int(10) UNSIGNED NOT NULL,
  `producto_id` int(11) NOT NULL,
  `carrito_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto_carrito`
--

INSERT INTO `producto_carrito` (`id`, `producto_id`, `carrito_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 1, 2),
(12, 2, 3),
(13, 3, 4),
(14, 4, 5),
(15, 5, 6),
(16, 6, 7),
(17, 7, 8),
(18, 8, 9),
(19, 9, 10),
(20, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_carrito`
--

CREATE TABLE `usuario_carrito` (
  `id` int(10) UNSIGNED NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `carrito_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario_carrito`
--

INSERT INTO `usuario_carrito` (`id`, `usuario_id`, `carrito_id`) VALUES
(1, 1, 1),
(2, 3, 2),
(3, 5, 3),
(4, 2, 4),
(5, 7, 5),
(6, 4, 6),
(7, 9, 7),
(8, 8, 8),
(9, 6, 9),
(10, 10, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carritos`
--
ALTER TABLE `carritos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `compradores`
--
ALTER TABLE `compradores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto_carrito`
--
ALTER TABLE `producto_carrito`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario_carrito`
--
ALTER TABLE `usuario_carrito`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carritos`
--
ALTER TABLE `carritos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `compradores`
--
ALTER TABLE `compradores`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `producto_carrito`
--
ALTER TABLE `producto_carrito`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `usuario_carrito`
--
ALTER TABLE `usuario_carrito`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
