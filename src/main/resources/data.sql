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

INSERT INTO pais (nombre) VALUES ('Bolivia');
INSERT INTO pais (nombre) VALUES ('Chile');

INSERT INTO ciudad (nombre, pais_id) VALUES ('Santa Cruz',1);
INSERT INTO ciudad (nombre, pais_id) VALUES ('Cochabamba',1);
INSERT INTO ciudad (nombre, pais_id) VALUES ('La Paz',1);
INSERT INTO ciudad (nombre, pais_id) VALUES ('Beni',1);

INSERT INTO direccion (nombre, ubicacion, edificio, ciudad_id) VALUES ('Trabajo','Barrio los mangales', '456',1);
INSERT INTO direccion (nombre, ubicacion, ciudad_id) VALUES ('Colegio','Barrio totai',1);
INSERT INTO direccion (nombre, ubicacion, edificio, ciudad_id) VALUES ('Hogar','Barrio 24 de septiembre', '456',1);
INSERT INTO direccion (nombre, ubicacion,ciudad_id) VALUES ('Casa','Barrio los tajibos',2);

INSERT INTO permiso (nombre, descripcion) VALUES ('crear_empresa','Permite crear los datos de la empresa');
INSERT INTO permiso (nombre, descripcion) VALUES ('ver_empresa','Permite ver los datos de la empresa');
INSERT INTO permiso (nombre, descripcion) VALUES ('editar_empresa','Permite editar los datos de la empresa');
INSERT INTO permiso (nombre, descripcion) VALUES ('eliminar_empresa','Permite eliminar los datos de la empresa');

INSERT INTO rol (nombre) VALUES ('SuperUsuario');
INSERT INTO rol (nombre) VALUES ('Vendedor');
INSERT INTO rol (nombre) VALUES ('Cliente');

INSERT INTO rol_permiso (fecha_asignacion,permiso_id,rol_id) VALUES ('2024-09-19',1,1);
INSERT INTO rol_permiso (fecha_asignacion,permiso_id,rol_id) VALUES ('2024-09-19',2,1);
INSERT INTO rol_permiso (fecha_asignacion,permiso_id,rol_id) VALUES ('2024-09-19',3,1);
INSERT INTO rol_permiso (fecha_asignacion,permiso_id,rol_id) VALUES ('2024-09-19',4,1);
INSERT INTO rol_permiso (fecha_asignacion,permiso_id,rol_id) VALUES ('2024-09-19',2,2);
INSERT INTO rol_permiso (fecha_asignacion,permiso_id,rol_id) VALUES ('2024-09-19',2,3);

INSERT INTO sucursal (nombre, esta_activo, empresa_id, direccion_id) VALUES ('Sucursal 1', true,1,1);
INSERT INTO sucursal (nombre, esta_activo, empresa_id, direccion_id) VALUES ('Sucursal 2', true,2,2);

INSERT INTO almacen (nombre, sucursal_id) VALUES ('Almacen 1', 1);
INSERT INTO almacen (nombre, sucursal_id) VALUES ('Almacen 2', 1);
INSERT INTO almacen (nombre, sucursal_id) VALUES ('Almacen 3', 2);

INSERT INTO inventario (inventario_disponible,almacen_id,detalle_producto_id) VALUES (20, 1, 1);
INSERT INTO inventario (inventario_disponible,almacen_id,detalle_producto_id) VALUES (50, 2, 1);
INSERT INTO inventario (inventario_disponible,almacen_id,detalle_producto_id) VALUES (10, 1, 2);

-- {
--   "correo": "superusuario1@gmail.com",
--   "contrasena": "Superusuario1pass",
--   "nombre": "Super",
--   "apellido": "Usuario",
--   "sexo": "M",
--   "estaActivo": true,
--   "rol": {
--     "id": 1  // ID del rol 'SuperUsuario'
--   }
-- }

-- {
--   "correo": "vendedor1@gmail.com",
--   "contrasena": "vendedor1pass",
--   "nombre": "Vendedor",
--   "apellido": "Pro",
--   "sexo": "M",
--   "estaActivo": true,
--   "rol": {
--     "id": 2  // ID del rol 'Vendedor'
--   }
-- }

-- {
--   "correo": "cliente1@gmail.com",
--   "contrasena": "Cliente1pass",
--   "nombre": "Cliente",
--   "apellido": "Vip",
--   "sexo": "M",
--   "estaActivo": true,
--   "rol": {
--     "id": 3  // ID del rol 'Cliente'
--   }
-- }

-- UsuarioDireccion

-- {
--   "fechaCreacion": "2024-09-19",
--   "direccion": {
--     "id": 1  // ID de la dirección correspondiente
--   },
--   "usuario": {
--     "id": 3  // ID del usuario 'cliente1@gmail.com'
--   }
-- }

-- {
--   "fechaCreacion": "2024-09-19",
--   "direccion": {
--     "id": 2
--   },
--   "usuario": {
--     "id": 3
--   }
-- }

-- {
--   "fechaCreacion": "2024-09-30",
--   "direccion": {
--     "id": 3
--   },
--   "usuario": {
--     "id": 2  // ID del usuario 'vendedor1@gmail.com'
--   }
-- }

-- {
--   "fechaCreacion": "2024-10-10",
--   "direccion": {
--     "id": 4
--   },
--   "usuario": {
--     "id": 1  // ID del usuario 'superusuario1@gmail.com'
--   }
-- }

-- UsuarioSucursal
-- {
--   "fechaInicio": "2024-09-19",
--   "sucursal": {
--     "id": 1  // ID de la sucursal correspondiente
--   },
--   "usuario": {
--     "id": 1  // ID del usuario 'superusuario1@gmail.com'
--   }
-- }

-- {
--   "fechaInicio": "2024-09-25",
--   "sucursal": {
--     "id": 2
--   },
--   "usuario": {
--     "id": 2  // ID del usuario 'vendedor1@gmail.com'
--   }
-- }