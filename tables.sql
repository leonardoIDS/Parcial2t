-- Create syntax for TABLE 'CONSULTAS'
CREATE TABLE `CONSULTAS` (
  `idCONSULTAS` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_y_hora` datetime NOT NULL,
  `resumen` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `PACIENTES_id` int(11) NOT NULL DEFAULT '0',
  `PACIENTES_tipo_id` enum('cc','ce','rc','ti') COLLATE latin1_general_ci NOT NULL DEFAULT 'cc',
  PRIMARY KEY (`idCONSULTAS`),
  KEY `fk_CONSULTAS_PACIENTES1` (`PACIENTES_id`,`PACIENTES_tipo_id`),
  CONSTRAINT `fk_CONSULTAS_PACIENTES1` FOREIGN KEY (`PACIENTES_id`, `PACIENTES_tipo_id`) REFERENCES `PACIENTES` (`id`, `tipo_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=664 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Create syntax for TABLE 'PACIENTES'
CREATE TABLE `PACIENTES` (
  `id` int(11) NOT NULL,
  `tipo_id` enum('cc','ce','rc','ti') COLLATE latin1_general_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`id`,`tipo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;