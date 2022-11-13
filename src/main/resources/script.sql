INSERT INTO `categoria` (`id`, `nombre`) VALUES ('1', '10 libras'), ('2', '25 libras'),
('3', '35 libras'), ('4', '100 libras');

INSERT INTO `producto` (`id`, `marca`, `nombre`, `precio`, `categoria_id`) VALUES ('1', 'Shellane', 'Cilindro de Gas', '18.43', '3'), ('2', 'Zeta Gas', 'Cilindro de Gas', '13.22', '2'), ('3', 'Tropigas', 'Cilindro de gas', '5.46', '1');

INSERT INTO `solicitud` (`id`, `clave`, `dui`, `estado`, `fecha_ingreso`, `producto_id`) VALUES ('1', '123', '123456789', 'Ingresada', '2022-11-12 17:27:47', '3'), ('2', '123', '987654321', 'Ingresado', '2022-11-12 17:27:47', '1');

INSERT INTO `rol` (`id`, `nombre`) VALUES ('1', 'Administrador'), ('2', 'Vendedor'), ('3', 'Tecnico');

INSERT INTO `usuario` (`id`, `correo`, `nombre`, `password`, `user`, `rol_id`) VALUES ('1', 'admin@correo.com', 'Admin', '123', 'admin', '1');

INSERT INTO `beneficio` (`id`, `nombre`) VALUES ('1', 'General'), ('2', 'Focalizado');

INSERT INTO `beneficiario` (`id`, `clave`, `direccion`, `dui`, `nombre`, `beneficio_id`) VALUES ('1', '123', 'San Salvador', '123456789', 'Juan Pérez', '2'), ('2', '123', 'Soyapango', '987654321', 'Jose Jose', '1'), ('3', '123', 'Mejicanos', '111122223', 'Margarita del Campo', '2'), ('4', '123', 'San Martin', '222233334', 'Chamba Perez', '1');

INSERT INTO `subsidio` (`id`, `activo`, `canjeos`, `monto`, `beneficio_id`, `producto_id`) VALUES ('1', NULL, '1', '0.85', '1', '3'), ('2', NULL, '1', '5.46', '2', '3'), ('3', NULL, '1', '2.09', '1', '2'), ('4', NULL, '1', '10.13', '2', '2'), ('5', NULL, '1', '2.93', '1', '3'), ('6', NULL, '1', '10.97', '2', '3');

//Insertar en energia

INSERT INTO `empresa` (`id`, `nombre`) VALUES ('1', 'CAESS'), ('2', 'DELSUR'), ('3', 'EEO');

INSERT INTO `consumo` (`id`, `consumo`, `dui`, `empresa_id`, `periodo`) VALUES ('1', '94', '123456789', '1', '2022/09/21 17:27:47'), ('2', '110', '987654321', '2', '2022/11/11 17:27:47'), ('3', '89', '987654321', '2', '2022/10/02 17:27:47'), ('4', '73', '111122223', '1', '2022/11/02 17:27:47'), ('5', '110', '111122223', '2', '2022/10/11 17:27:47'), ('6', '110', '123456789', '1', '2022/09/15 17:27:47');
