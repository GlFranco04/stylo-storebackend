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

INSERT INTO empresa (nombre, correo, telefono, propietario) VALUES ('Empresa 1', 'empresa1@gmail.com', '+591 11111111', 'Propietario 1');
INSERT INTO empresa (nombre, correo, telefono, propietario) VALUES ('Empresa 2', 'empresa2@gmail.com', '+591 22222222', 'Propietario 2');
INSERT INTO empresa (nombre, correo, telefono, propietario) VALUES ('Empresa 3', 'empresa1@gmail.com', '+591 33333333', 'Propietario 3');

INSERT INTO direccion (nombre, ubicacion, edificio) VALUES ('Trabajo','Barrio los mangales', '456');
INSERT INTO direccion (nombre, ubicacion) VALUES ('Casa','Barrio los tajibos');

INSERT INTO sucursal (nombre, esta_activo, empresa_id, direccion_id) VALUES ('Sucursal 1', true,1,1);
INSERT INTO sucursal (nombre, esta_activo, empresa_id, direccion_id) VALUES ('Sucursal 2', true,2,2);

INSERT INTO almacen (nombre, sucursal_id) VALUES ('Almacen 1', 1);
INSERT INTO almacen (nombre, sucursal_id) VALUES ('Almacen 2', 1);
INSERT INTO almacen (nombre, sucursal_id) VALUES ('Almacen 3', 2);

INSERT INTO inventario (inventario_disponible,almacen_id,detalle_producto_id) VALUES (20, 1, 1);
INSERT INTO inventario (inventario_disponible,almacen_id,detalle_producto_id) VALUES (50, 2, 1);
INSERT INTO inventario (inventario_disponible,almacen_id,detalle_producto_id) VALUES (10, 1, 2);

INSERT INTO usuario_sucursal (fecha_inicio, sucursal_id) VALUES ('2024-09-19', 1);
INSERT INTO usuario_sucursal (fecha_inicio, sucursal_id) VALUES ('2024-09-25', 2);