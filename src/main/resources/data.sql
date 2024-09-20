INSERT INTO categoria (nombre, descripcion, esta_activo) VALUES ('Ropa Deportiva', 'Ropa para hacer deporte', true);
INSERT INTO categoria (nombre, descripcion, esta_activo) VALUES ('Invernal', 'Ropa para la tempordad de invierno', true);

INSERT INTO producto (nombre, descripcion, fecha_creacion, esta_activo) VALUES ('Polera de Algodón', 'Polera cómoda de algodón 100%', '2024-09-19', true);
INSERT INTO producto (nombre, descripcion, fecha_creacion, esta_activo) VALUES ('Falda de Algodón', 'Falda cómoda de algodón 100%', '2024-09-19', true);

INSERT INTO talla (nombre, esta_activo) VALUES ('S', true);
INSERT INTO talla (nombre, esta_activo) VALUES ('M', true);
INSERT INTO talla (nombre, esta_activo) VALUES ('L', true);


INSERT INTO detalle_producto (color, precio, producto_id, talla_id) VALUES ('Azul', 30.99, 1, 1);
INSERT INTO detalle_producto (color, precio, producto_id, talla_id) VALUES ('Rojo', 49.99, 1, 1);

INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (1, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (1, 2);
