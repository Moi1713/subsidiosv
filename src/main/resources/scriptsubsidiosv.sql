INSERT INTO `categoria` (`id`, `nombre`) VALUES ('1', '10 libras'), ('2', '25 libras'),
('3', '35 libras'), ('4', '100 libras');

INSERT INTO `producto` (`id`, `marca`, `nombre`, `precio`, `categoria_id`) VALUES ('1', 'Shellane', 'Cilindro de Gas', '18.43', '3'), ('2', 'Zeta Gas', 'Cilindro de Gas', '13.22', '2'), ('3', 'Tropigas', 'Cilindro de gas', '5.46', '1');

INSERT INTO `solicitud` (`id`, `clave`, `dui`, `estado`, `fecha_ingreso`, `producto_id`) VALUES ('1', '123', '123456789', 'Ingresada', '2022-11-12 17:27:47', '3'), ('2', '123', '987654321', 'Ingresado', '2022-11-12 17:27:47', '1');

INSERT INTO `rol` (`id`, `nombre`) VALUES ('1', 'Administrador'), ('2', 'Vendedor'), ('3', 'Tecnico');

INSERT INTO `usuario` (`id`, `correo`, `nombre`, `password`, `user`, `rol_id`) VALUES ('1', 'admin@correo.com', 'Admin', '$2a$12$Da1lpXzdbYNuHgMAGLUHm./XoknVkLAwu81EyrxSRlFsS0E7o22YK', 'admin', '1');
INSERT INTO `usuario` (`id`, `correo`, `nombre`, `password`, `username`, `rol_id`) VALUES (2, 'vendedor@correo.com', 'Ventas', '$2a$12$Da1lpXzdbYNuHgMAGLUHm./XoknVkLAwu81EyrxSRlFsS0E7o22YK', 'vendedor', '2'), (3, 'tecnico@correo.com', 'Técnico de Registro', '$2a$12$Da1lpXzdbYNuHgMAGLUHm./XoknVkLAwu81EyrxSRlFsS0E7o22YK', 'tecnico', '3');

INSERT INTO `beneficio` (`id`, `nombre`) VALUES ('1', 'General'), ('2', 'Focalizado');

INSERT INTO `beneficiario` (`id`, `clave`, `direccion`, `dui`, `nombre`, `beneficio_id`) VALUES ('1', '123', 'San Salvador', '123456789', 'Juan Pérez', '2'), ('2', '123', 'Soyapango', '987654321', 'Jose Jose', '1'), ('3', '123', 'Mejicanos', '111122223', 'Margarita del Campo', '2'), ('4', '123', 'San Martin', '222233334', 'Chamba Perez', '1');

INSERT INTO `subsidio` (`id`, `activo`, `canjeos`, `monto`, `beneficio_id`, `producto_id`) VALUES ('1', NULL, '1', '0.85', '1', '3'), ('2', NULL, '1', '5.46', '2', '3'), ('3', NULL, '1', '2.09', '1', '2'), ('4', NULL, '1', '10.13', '2', '2'), ('5', NULL, '1', '2.93', '1', '1'), ('6', NULL, '1', '10.97', '2', '1');

