package com.bosonit.formacion.block11uploaddownloadfiles.application;

import com.bosonit.formacion.block11uploaddownloadfiles.domain.Fichero;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FicheroService {
    Fichero addFichero(MultipartFile archivo);
    void removeFichero(Integer id);
    Resource getFicheroById(Integer id);
}
