package com.stylo.store.controllers;

import com.stylo.store.models.*;
import com.stylo.store.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/api/seeder")
public class SeederController{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TallaRepository tallaRepository;

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolPermisoRepository rolPermisoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private UsuarioSucursalRepository usuarioSucursalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public void run(String... args) throws Exception {
        seedCategorias();
        seedProveedores();
        seedProductos();
        seedTallas();
        seedDetalleProductos();
        seedProductoCategorias();
        seedPaises();
        seedCiudades();
        seedPermisos();
        seedRoles();
        seedRolPermisos();
        seedUsuarios();
        seedDirecciones();
        seedEmpresas();
        seedSucursales();
        seedInventarios();
        seedUsuarioSucursales();
    }

    private void seedCategorias() {
        if (categoriaRepository.count() == 0) {
            Categoria c1 = new Categoria();
            c1.setNombre("Ropa Deportiva");
            c1.setDescripcion("Ropa para hacer deporte");
            c1.setEstaActivo(true);

            Categoria c2 = new Categoria();
            c2.setNombre("Invernal");
            c2.setDescripcion("Ropa para la temporada de invierno");
            c2.setEstaActivo(true);

            categoriaRepository.saveAll(Arrays.asList(c1, c2));
        }
    }

    private void  seedProveedores(){
        if (proveedorRepository.count() == 0) {
            Proveedor p1 = new Proveedor();
            p1.setNombre("Estilo Moda");

            Proveedor p2 = new Proveedor();
            p2.setNombre("Estilo Moda 2");

            proveedorRepository.saveAll(Arrays.asList(p1, p2));
        }
    }

    private void seedProductos() {
        if (productoRepository.count() == 0) {
            Optional<Proveedor> proveedor1 = proveedorRepository.findByNombre("Estilo Moda"); 
            Optional<Proveedor> proveedor2 = proveedorRepository.findByNombre("Estilo Moda 2"); 
            Producto p1 = new Producto();
            p1.setNombre("Polera de Algodón");
            p1.setDescripcion("Polera cómoda de algodón 100%");
            p1.setFechaCreacion(LocalDate.of(2024, 9, 19));
            p1.setEstaActivo(true);
            p1.setProveedor(proveedor1.get());

            Producto p2 = new Producto();
            p2.setNombre("Falda de Algodón");
            p2.setDescripcion("Falda cómoda de algodón 100%");
            p2.setFechaCreacion(LocalDate.of(2024, 9, 19));
            p2.setEstaActivo(true);
            p2.setProveedor(proveedor2.get());

            productoRepository.saveAll(Arrays.asList(p1, p2));
        }
    }

    private void seedTallas() {
        if (tallaRepository.count() == 0) {
            Talla t1 = new Talla();
            t1.setNombre("S");
            t1.setEstaActivo(true);

            Talla t2 = new Talla();
            t2.setNombre("M");
            t2.setEstaActivo(true);

            Talla t3 = new Talla();
            t3.setNombre("L");
            t3.setEstaActivo(true);

            tallaRepository.saveAll(Arrays.asList(t1, t2, t3));
        }
    }

    private void seedDetalleProductos() {
        if (detalleProductoRepository.count() == 0) {
            // Obtener referencias a productos y tallas
            Optional<Producto> producto1 = productoRepository.findByNombre("Polera de Algodón");
            Optional<Talla> tallaS = tallaRepository.findByNombre("S");

            if (producto1.isPresent() && tallaS.isPresent()) {
                DetalleProducto dp1 = new DetalleProducto();
                dp1.setColor("Azul");
                dp1.setPrecioCompra(30.50);
                dp1.setPrecioVenta(59.99);
                dp1.setProducto(producto1.get());
                dp1.setTalla(tallaS.get());

                DetalleProducto dp2 = new DetalleProducto();
                dp2.setColor("Rojo");
                dp2.setPrecioCompra(30.50);
                dp2.setPrecioVenta(65.00);
                dp2.setProducto(producto1.get());
                dp2.setTalla(tallaS.get());

                detalleProductoRepository.saveAll(Arrays.asList(dp1, dp2));
            }
        }
    }

    private void seedProductoCategorias() {
        if (productoCategoriaRepository.count() == 0) {
            // Obtener referencias a productos y categorías
            Optional<Producto> producto1 = productoRepository.findByNombre("Polera de Algodón");
            Optional<Categoria> categoria1 = categoriaRepository.findByNombre("Ropa Deportiva");
            Optional<Categoria> categoria2 = categoriaRepository.findByNombre("Invernal");

            if (producto1.isPresent() && categoria1.isPresent() && categoria2.isPresent()) {
                ProductoCategoria pc1 = new ProductoCategoria();
                pc1.setProducto(producto1.get());
                pc1.setCategoria(categoria1.get());

                ProductoCategoria pc2 = new ProductoCategoria();
                pc2.setProducto(producto1.get());
                pc2.setCategoria(categoria2.get());

                productoCategoriaRepository.saveAll(Arrays.asList(pc1, pc2));
            }
        }
    }

    private void seedPaises() {
        if (paisRepository.count() == 0) {
            Pais p1 = new Pais();
            p1.setNombre("Bolivia");

            Pais p2 = new Pais();
            p2.setNombre("Chile");

            paisRepository.saveAll(Arrays.asList(p1, p2));
        }
    }

    private void seedCiudades() {
        if (ciudadRepository.count() == 0) {
            Optional<Pais> bolivia = paisRepository.findByNombre("Bolivia");

            if (bolivia.isPresent()) {
                Ciudad c1 = new Ciudad();
                c1.setNombre("Santa Cruz");
                c1.setPais(bolivia.get());

                Ciudad c2 = new Ciudad();
                c2.setNombre("Cochabamba");
                c2.setPais(bolivia.get());

                Ciudad c3 = new Ciudad();
                c3.setNombre("La Paz");
                c3.setPais(bolivia.get());

                Ciudad c4 = new Ciudad();
                c4.setNombre("Beni");
                c4.setPais(bolivia.get());

                ciudadRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
            }
        }
    }

    private void seedDirecciones() {
        if (direccionRepository.count() == 0) {
            Optional<Ciudad> ciudad1 = ciudadRepository.findByNombre("Santa Cruz");
            Optional<Ciudad> ciudad2 = ciudadRepository.findByNombre("Cochabamba");
            Optional<Usuario> usuario1 = usuarioRepository.findByCorreo("cliente1@gmail.com");
            Optional<Usuario> usuario2 = usuarioRepository.findByCorreo("gabrielLopez@gmail.com");
            Optional<Usuario> usuario3 = usuarioRepository.findByCorreo("jack@gmail.com");

            if (ciudad1.isPresent() && ciudad2.isPresent()) {
                Direccion d1 = new Direccion();
                d1.setNombre("Trabajo");
                d1.setUbicacion("1Barrio los mangales");
                d1.setEdificio("456");
                d1.setCiudad(ciudad1.get());

                Direccion d2 = new Direccion();
                d2.setNombre("Colegio");
                d2.setUbicacion("2Barrio totai");
                d2.setCiudad(ciudad1.get());

                Direccion d3 = new Direccion();
                d3.setNombre("Oficina 4");
                d3.setUbicacion("3Barrio 24 de septiembre");
                d3.setEdificio("456");
                d3.setCiudad(ciudad1.get());

                Direccion d4 = new Direccion();
                d4.setNombre("Oficina 3");
                d4.setUbicacion("4Barrio los tajibos");
                d4.setCiudad(ciudad2.get());

                Direccion d5 = new Direccion();
                d5.setNombre("Casa");
                d5.setUbicacion("5Avenida Paragua");
                d5.setUsuario(usuario1.get());
                d5.setCiudad(ciudad2.get());

                Direccion d6 = new Direccion();
                d6.setNombre("Casa");
                d6.setUbicacion("6Avenida San Juan");
                d6.setUsuario(usuario2.get());
                d6.setCiudad(ciudad2.get());

                Direccion d7 = new Direccion();
                d7.setNombre("Casa");
                d7.setUbicacion("7Avenida San Roque");
                d7.setUsuario(usuario3.get());
                d7.setCiudad(ciudad2.get());
                direccionRepository.saveAll(Arrays.asList(d1, d2, d3, d4,d5,d6,d7));
            }
        }
    }

    private void seedPermisos() {
        if (permisoRepository.count() == 0) {
            Permiso p1 = new Permiso();
            p1.setNombre("crear_empresa");
            p1.setDescripcion("Permite crear los datos de la empresa");

            Permiso p2 = new Permiso();
            p2.setNombre("ver_empresa");
            p2.setDescripcion("Permite ver los datos de la empresa");

            Permiso p3 = new Permiso();
            p3.setNombre("editar_empresa");
            p3.setDescripcion("Permite editar los datos de la empresa");

            Permiso p4 = new Permiso();
            p4.setNombre("eliminar_empresa");
            p4.setDescripcion("Permite eliminar los datos de la empresa");

            Permiso p6 = new Permiso();
            p6.setNombre("crear_producto");
            p6.setDescripcion("Permite crear los datos del producto");

            Permiso p7 = new Permiso();
            p7.setNombre("ver_producto");
            p7.setDescripcion("Permite ver los datos del producto");

            Permiso p8 = new Permiso();
            p8.setNombre("editar_producto");
            p8.setDescripcion("Permite editar los datos del producto");

            Permiso p9 = new Permiso();
            p9.setNombre("eliminar_producto");
            p9.setDescripcion("Permite eliminar los datos del producto");


            permisoRepository.saveAll(Arrays.asList(p1, p2, p3, p4,p6,p7,p8,p9));
        }
    }

    private void seedRoles() {
        if (rolRepository.count() == 0) {
            Rol r1 = new Rol();
            r1.setNombre("SuperUsuario");

            Rol r2 = new Rol();
            r2.setNombre("Vendedor");

            Rol r3 = new Rol();
            r3.setNombre("Cliente");

            rolRepository.saveAll(Arrays.asList(r1, r2, r3));
        }
    }

    private void seedRolPermisos() {
        if (rolPermisoRepository.count() == 0) {
            // Obtener roles y permisos
            Optional<Rol> superUsuario = rolRepository.findByNombre("SuperUsuario");
            Optional<Rol> vendedor = rolRepository.findByNombre("Vendedor");
            Optional<Rol> cliente = rolRepository.findByNombre("Cliente");

            Optional<Permiso> crearEmpresa = permisoRepository.findByNombre("crear_empresa");
            Optional<Permiso> verEmpresa = permisoRepository.findByNombre("ver_empresa");
            Optional<Permiso> editarEmpresa = permisoRepository.findByNombre("editar_empresa");
            Optional<Permiso> eliminarEmpresa = permisoRepository.findByNombre("eliminar_empresa");
            Optional<Permiso> crearProducto = permisoRepository.findByNombre("crear_producto");
            Optional<Permiso> verProducto = permisoRepository.findByNombre("ver_producto");
            Optional<Permiso> editarProducto = permisoRepository.findByNombre("editar_producto");
            Optional<Permiso> eliminarProducto = permisoRepository.findByNombre("eliminar_producto");

            if (superUsuario.isPresent() && vendedor.isPresent() && cliente.isPresent()
                    && crearEmpresa.isPresent() && verEmpresa.isPresent()
                    && editarEmpresa.isPresent() && eliminarEmpresa.isPresent()) {

                LocalDate fechaAsignacion = LocalDate.of(2024, 9, 19);

                RolPermiso rp1 = new RolPermiso();
                rp1.setFechaAsignacion(fechaAsignacion);
                rp1.setRol(superUsuario.get());
                rp1.setPermiso(crearEmpresa.get());

                RolPermiso rp2 = new RolPermiso();
                rp2.setFechaAsignacion(fechaAsignacion);
                rp2.setRol(superUsuario.get());
                rp2.setPermiso(verEmpresa.get());

                RolPermiso rp3 = new RolPermiso();
                rp3.setFechaAsignacion(fechaAsignacion);
                rp3.setRol(superUsuario.get());
                rp3.setPermiso(editarEmpresa.get());

                RolPermiso rp4 = new RolPermiso();
                rp4.setFechaAsignacion(fechaAsignacion);
                rp4.setRol(superUsuario.get());
                rp4.setPermiso(eliminarEmpresa.get());

                RolPermiso rp7 = new RolPermiso();
                rp7.setFechaAsignacion(fechaAsignacion);
                rp7.setRol(superUsuario.get());
                rp7.setPermiso(crearProducto.get());

                RolPermiso rp8 = new RolPermiso();
                rp8.setFechaAsignacion(fechaAsignacion);
                rp8.setRol(superUsuario.get());
                rp8.setPermiso(verProducto.get());

                RolPermiso rp9 = new RolPermiso();
                rp9.setFechaAsignacion(fechaAsignacion);
                rp9.setRol(superUsuario.get());
                rp9.setPermiso(editarProducto.get());

                RolPermiso rp10 = new RolPermiso();
                rp10.setFechaAsignacion(fechaAsignacion);
                rp10.setRol(superUsuario.get());
                rp10.setPermiso(eliminarProducto.get());

                RolPermiso rp5 = new RolPermiso();
                rp5.setFechaAsignacion(fechaAsignacion);
                rp5.setRol(vendedor.get());
                rp5.setPermiso(verEmpresa.get());

                RolPermiso rp6 = new RolPermiso();
                rp6.setFechaAsignacion(fechaAsignacion);
                rp6.setRol(cliente.get());
                rp6.setPermiso(verEmpresa.get());

                rolPermisoRepository.saveAll(Arrays.asList(rp1, rp2, rp3, rp4, rp5, rp6,rp7,rp8,rp9,rp10));
            }
        }
    }

    private void seedUsuarios() {
        if (usuarioRepository.count() == 0) {
            Optional<Rol> superUsuario = rolRepository.findByNombre("SuperUsuario");
            Optional<Rol> vendedor = rolRepository.findByNombre("Vendedor");
            Optional<Rol> cliente = rolRepository.findByNombre("Cliente");

            if (superUsuario.isPresent() && vendedor.isPresent() && cliente.isPresent()) {
                Usuario u1 = new Usuario();
                u1.setCorreo("superusuario1@gmail.com");
                u1.setContrasena(passwordEncoder.encode("Superusuario1pass"));
                u1.setNombre("Super");
                u1.setApellido("Usuario");
                u1.setSexo('M');
                u1.setEstaActivo(true);
                u1.setRol(superUsuario.get());

                Usuario u2 = new Usuario();
                u2.setCorreo("vendedor1@gmail.com");
                u2.setContrasena(passwordEncoder.encode("vendedor1pass"));
                u2.setNombre("Vendedor");
                u2.setApellido("Pro");
                u2.setSexo('M');
                u2.setEstaActivo(true);
                u2.setRol(vendedor.get());

                Usuario u3 = new Usuario();
                u3.setCorreo("cliente1@gmail.com");
                u3.setContrasena(passwordEncoder.encode("Cliente1pass"));
                u3.setNombre("Cliente");
                u3.setApellido("Vip");
                u3.setSexo('F');
                u3.setEstaActivo(true);
                u3.setRol(cliente.get());

                Usuario u4 = new Usuario();
                u4.setCorreo("gabrielLopez@gmail.com");
                u4.setContrasena(passwordEncoder.encode("Cliente1pass"));
                u4.setNombre("Gabriel");
                u4.setApellido("López");
                u4.setSexo('M');
                u4.setEstaActivo(true);
                u4.setRol(cliente.get());

                Usuario u5 = new Usuario();
                u5.setCorreo("jack@gmail.com");
                u5.setContrasena(passwordEncoder.encode("Cliente1pass"));
                u5.setNombre("Jack");
                u5.setApellido("López");
                u5.setSexo('M');
                u5.setEstaActivo(true);
                u5.setRol(cliente.get());

                usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
            }
        }
    }

    private void seedEmpresas() {
        if (empresaRepository.count() == 0) {
            Empresa e1 = new Empresa();
            e1.setNombre("Empresa 1");
            e1.setCorreo("empresa1@gmail.com");
            e1.setTelefono("+591 11111111");
            e1.setPropietario("Propietario 1");

            Empresa e2 = new Empresa();
            e2.setNombre("Empresa 2");
            e2.setCorreo("empresa2@gmail.com");
            e2.setTelefono("+591 22222222");
            e2.setPropietario("Propietario 2");

            Empresa e3 = new Empresa();
            e3.setNombre("Empresa 3");
            e3.setCorreo("empresa3@gmail.com");
            e3.setTelefono("+591 33333333");
            e3.setPropietario("Propietario 3");

            empresaRepository.saveAll(Arrays.asList(e1, e2, e3));
        }
    }

    private void seedSucursales() {
        if (sucursalRepository.count() == 0) {
            Optional<Empresa> e1 = empresaRepository.findByNombre("Empresa 1");
            Optional<Empresa> e2 = empresaRepository.findByNombre("Empresa 2");

            Optional<Direccion> d1 = direccionRepository.findByNombre("Trabajo");
            Optional<Direccion> d2 = direccionRepository.findByNombre("Colegio");

            if (e1.isPresent() && e2.isPresent() && d1.isPresent() && d2.isPresent()) {
                Sucursal s1 = new Sucursal();
                s1.setNombre("Sucursal 1");
                s1.setEstaActivo(true);
                s1.setEmpresa(e1.get());
                s1.setDireccion(d1.get());

                Sucursal s2 = new Sucursal();
                s2.setNombre("Sucursal 2");
                s2.setEstaActivo(true);
                s2.setEmpresa(e2.get());
                s2.setDireccion(d2.get());

                sucursalRepository.saveAll(Arrays.asList(s1, s2));
            }
        }
    }

    private void seedInventarios() {
        if (inventarioRepository.count() == 0) {
            Optional<Sucursal> sucursal1 = sucursalRepository.findByNombre("Sucursal 1");
            Optional<Sucursal> sucursal2 = sucursalRepository.findByNombre("Sucursal 2");

            Optional<DetalleProducto> dp1 = detalleProductoRepository.findByColor("Azul");
            Optional<DetalleProducto> dp2 = detalleProductoRepository.findByColor("Rojo");

            if (sucursal1.isPresent() && sucursal2.isPresent() && dp1.isPresent() && dp2.isPresent()) {
                Inventario i1 = new Inventario();
                i1.setInventarioDisponible((long) 20);
                i1.setSucursal(sucursal1.get());
                i1.setDetalleProducto(dp1.get());

                Inventario i2 = new Inventario();
                i2.setInventarioDisponible((long) 50);
                i2.setSucursal(sucursal2.get());
                i2.setDetalleProducto(dp1.get());

                Inventario i3 = new Inventario();
                i3.setInventarioDisponible((long) 10);
                i3.setSucursal(sucursal1.get());
                i3.setDetalleProducto(dp2.get());

                inventarioRepository.saveAll(Arrays.asList(i1, i2, i3));
            }
        }
    }

    private void seedUsuarioSucursales() {
        if (usuarioSucursalRepository.count() == 0) {
            Optional<Usuario> u1 = usuarioRepository.findByCorreo("superusuario1@gmail.com");
            Optional<Usuario> u2 = usuarioRepository.findByCorreo("vendedor1@gmail.com");

            Optional<Sucursal> s1 = sucursalRepository.findByNombre("Sucursal 1");
            Optional<Sucursal> s2 = sucursalRepository.findByNombre("Sucursal 2");

            if (u1.isPresent() && u2.isPresent() && s1.isPresent() && s2.isPresent()) {
                UsuarioSucursal us1 = new UsuarioSucursal();
                us1.setFechaInicio(LocalDate.of(2024, 9, 19));
                us1.setUsuario(u1.get());
                us1.setSucursal(s1.get());

                UsuarioSucursal us2 = new UsuarioSucursal();
                us2.setFechaInicio(LocalDate.of(2024, 9, 25));
                us2.setUsuario(u2.get());
                us2.setSucursal(s2.get());

                usuarioSucursalRepository.saveAll(Arrays.asList(us1, us2));
            }
        }
    }
}
