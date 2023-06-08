# pruebaspringmvckonecta

* Para esta solución se utilizó como base de datos MySQL, se creo una base de datos llamada "konectadb", la cual se utiliza en entorno local mediante el localhost expuesta en el
* puerto 3306, se crearon 2 tablas, empleado y solicitud, estos son los script de creacion:

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE `empleado` (
  `id` bigint(20) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `salario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `empleado_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `empleado_seq` (`next_val`) VALUES
(101);

CREATE TABLE `solicitud` (
  `id` bigint(20) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `resumen` varchar(50) NOT NULL,
  `id_empleado` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `solicitud_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `solicitud_seq` (`next_val`) VALUES
(101);


ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKuihhkj0g5em5a1k57fo4ttwx` (`id_empleado`);


ALTER TABLE `solicitud`
  ADD CONSTRAINT `FKuihhkj0g5em5a1k57fo4ttwx` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id`);

* Se conecta la aplicacion mediante las credenciales expuestas en application.propperties
* Finalmente se procede a ejecutar la aplicacion para levantar el servicio MVC y así se ve la aplicación:

![Inicio](img/Captura%20de%20pantalla%202023-06-08%20070046.jpg)

![Empleados](img/Captura%20de%20pantalla%202023-06-08%20070158.jpg)

![Nuevo empleado](img/Captura%20de%20pantalla%202023-06-08%20070220.jpg)

![Solicitudes](img/Captura%20de%20pantalla%202023-06-08%20070306.jpg)

![Nuevas solicitudes](img/Captura%20de%20pantalla%202023-06-08%20070329.jpg)