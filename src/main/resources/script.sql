INSERT INTO `categoria` (`id`, `nombre`) VALUES ('1', '10 libras'), ('2', '25 libras'),
('3', '35 libras'), ('4', '100 libras');


INSERT INTO `producto` (`id`, `marca`, `nombre`, `precio`, `categoria_id`) VALUES ('1', 'Shellane', 'Cilindro de Gas', '18.43', '3'), ('2', 'Zeta Gas', 'Cilindro de Gas', '13.22', '2'), ('3', 'Tropigas', 'Cilindro de gas', '5.46', '1');


INSERT INTO `solicitud` (`id`, `clave`, `dui`, `estado`, `fecha_ingreso`, `producto_id`) VALUES ('1', '123', '123456789', 'Ingresada', '2022-11-12 17:27:47', '3'), ('2', '123', '987654321', 'Ingresado', '2022-11-12 17:27:47', '1');

INSERT INTO `rol` (`id`, `nombre`) VALUES ('1', 'Administrador'), ('2', 'Vendedor'), ('3', 'Tecnico');

INSERT INTO `usuario` (`id`, `correo`, `nombre`, `password`, `user`, `rol_id`) VALUES ('1', 'admin@correo.com', 'Admin', '123', 'admin', '1');
