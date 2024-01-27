package fr.limayrac.declarationFrais.declarationFrais.service;

import fr.limayrac.declarationFrais.declarationFrais.exception.FileNotFoundException;
import fr.limayrac.declarationFrais.declarationFrais.exception.FileStorageException;
import fr.limayrac.declarationFrais.declarationFrais.model.JustificatifFile;
import fr.limayrac.declarationFrais.declarationFrais.model.MealExpense;
import fr.limayrac.declarationFrais.declarationFrais.repository.JustificatifFileRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Data
@Service("justificatifFileService")
public class JustificatifFileService {

    @Autowired
    private JustificatifFileRepository justificatifFileRepository;

    public JustificatifFile storeFile(MealExpense mealExpense, MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            JustificatifFile justificatifFile = new JustificatifFile(fileName, file.getContentType(), file.getBytes());
            mealExpense.setJustificatif(justificatifFile);


            return justificatifFileRepository.save(justificatifFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Optional<JustificatifFile> getFile(String fileId) {
        UUID uuid;
        try {
            uuid = UUID.fromString(fileId);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return justificatifFileRepository.findById(uuid);
    }
}
