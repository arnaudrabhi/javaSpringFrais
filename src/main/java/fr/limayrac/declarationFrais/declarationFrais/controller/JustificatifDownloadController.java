package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.model.JustificatifFile;
import fr.limayrac.declarationFrais.declarationFrais.service.JustificatifFileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class JustificatifDownloadController {
    @Autowired
    private JustificatifFileService fileStorageService;

    @Autowired
    private JustificatifFileService justificatifFileService;

    @GetMapping("/downloadFile/{fileUUID:.+}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileUUID, HttpServletRequest request) {
        Optional<JustificatifFile> justificatifFileOptional = justificatifFileService.getFile(fileUUID);

        if (justificatifFileOptional.isPresent()) {
            JustificatifFile justificatifFile = justificatifFileOptional.get();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(justificatifFile.getFileType()));
            headers.setContentDispositionFormData("attachment", justificatifFile.getFileName());
            headers.setContentLength(justificatifFile.getData().length);

            return new ResponseEntity<>(justificatifFile.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/downloadFile/all")
    public ResponseEntity<byte[]> downloadFiles(HttpServletRequest request) {
        Optional<JustificatifFile> justificatifFileOptional = Optional.ofNullable(justificatifFileService.getJustificatifFileRepository().findAll().get(0));

        if (justificatifFileOptional.isPresent()) {
            JustificatifFile justificatifFile = justificatifFileOptional.get();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(justificatifFile.getFileType()));
            headers.setContentDispositionFormData("attachment", justificatifFile.getFileName());
            headers.setContentLength(justificatifFile.getData().length);

            return new ResponseEntity<>(justificatifFile.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
