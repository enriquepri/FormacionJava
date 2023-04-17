package com.bosonit.formacion.block11uploaddownloadfiles.application;

import com.bosonit.formacion.block11uploaddownloadfiles.domain.Fichero;
import com.bosonit.formacion.block11uploaddownloadfiles.repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FicheroServiceImpl implements FicheroService{
    private String ruta;

    @Autowired
    FicheroRepository ficheroRepository;

    public void setRuta(String ruta){
        this.ruta = ruta;
    }

    @Override
    public Fichero addFichero(MultipartFile archivo) {
        Fichero fichero = new Fichero();
        fichero.setTipo(FilenameUtils.getExtension(archivo.getOriginalFilename()));
        fichero.setNombre(FilenameUtils.getBaseName(archivo.getOriginalFilename()));
        fichero.setFechaSubida(java.time.LocalDate.now().toString());

        String dir = ruta + "/";
        File file = new File(dir + archivo.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(archivo.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ficheroRepository.save(fichero);
    }

    @Override
    public void removeFichero(Integer id) {

    }

    @Override
    public Resource getFicheroById(Integer id) {
        Fichero ficheroDevolver = ficheroRepository.findById(id).orElseThrow();

        try {
            Path file = Paths.get("ficheros/" + ficheroDevolver.getNombre() + "." + ficheroDevolver.getTipo());
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new Exception(
                        "Could not read file : " + id);

            }
        }catch (Exception e) {
            throw new RuntimeException("Could not read file: " + id);
        }
    }
}
