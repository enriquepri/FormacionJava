package com.bosonit.formacion.block11uploaddownloadfiles.application;

import com.bosonit.formacion.block11uploaddownloadfiles.domain.Fichero;
import com.bosonit.formacion.block11uploaddownloadfiles.repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;

@Service
public class FicheroServiceImpl implements FicheroService{
    @Autowired
    FicheroRepository ficheroRepository;

    @Override
    public Fichero addFichero(MultipartFile archivo) {
        Fichero fichero = new Fichero();
        fichero.setTipo(FilenameUtils.getExtension(archivo.getOriginalFilename()));
        fichero.setNombre(FilenameUtils.getBaseName(archivo.getOriginalFilename()));
        fichero.setFechaSubida(java.time.LocalDate.now().toString());
        return ficheroRepository.save(fichero);
    }

    @Override
    public void removeFichero(Integer id) {

    }

    @Override
    public Fichero getFicheroById(Integer id) {
        return null;
    }
}
