// ArchivoService.java
package com.stylo.store.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stylo.store.models.Archivo;
import com.stylo.store.repositories.ArchivoRepository;

@Service
public class ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    public String guardarArchivo(MultipartFile archivo) throws IOException {
        // Define una ubicación donde se almacenará el archivo
        String directorio = "archivos/";
        File directorioArchivo = new File(directorio);
        if (!directorioArchivo.exists()) {
            directorioArchivo.mkdirs(); // Crear el directorio si no existe
        }

        // Obtener el nombre original del archivo y definir la ubicación donde se almacenará
        String nombreArchivo = archivo.getOriginalFilename();
        String ubicacion = directorio + nombreArchivo;

        // Guardar el archivo físicamente
        File file = new File(ubicacion);
        archivo.transferTo(file);

        // Guardar la información del archivo en la base de datos
        Archivo nuevoArchivo = new Archivo();
        nuevoArchivo.setNombre(nombreArchivo);
        nuevoArchivo.setUbicacion(ubicacion);
        nuevoArchivo.setTipo(archivo.getContentType());
        nuevoArchivo.setFechaSubida(LocalDate.now());

        archivoRepository.save(nuevoArchivo);

        return ubicacion;
    }

    public Optional<Archivo> obtenerArchivoPorId(Long id) {
        return archivoRepository.findById(id);
    }

    public void eliminarArchivo(Long id) {
        archivoRepository.deleteById(id);
    }
}
