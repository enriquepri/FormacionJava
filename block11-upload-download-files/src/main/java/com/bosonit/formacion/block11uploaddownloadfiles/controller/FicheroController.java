package com.bosonit.formacion.block11uploaddownloadfiles.controller;

import com.bosonit.formacion.block11uploaddownloadfiles.application.FicheroService;
import com.bosonit.formacion.block11uploaddownloadfiles.domain.Fichero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FicheroController {
    @Autowired
    FicheroService ficheroService;

    @RequestMapping(path = "/fichero", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Fichero> addFichero(
            @RequestParam("file") MultipartFile archivo
            ){
        return ResponseEntity.ok().body(ficheroService.addFichero(archivo));
    }

    @RequestMapping(path = "/ficheroRedirect", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String addFichero(
            @RequestParam("file") MultipartFile archivo,
            RedirectAttributes redirectAttributes
    ){
        ficheroService.addFichero(archivo);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + archivo.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @GetMapping("/fichero/{id}")
    public Resource getById(
            @PathVariable Integer id
    ) {
        return ficheroService.getFicheroById(id);
    }

}
