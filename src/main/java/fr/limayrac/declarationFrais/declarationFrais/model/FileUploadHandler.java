package fr.limayrac.declarationFrais.declarationFrais.model;

import fr.limayrac.declarationFrais.declarationFrais.service.JustificatifFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHandler {

    @Autowired
    private JustificatifFileService justificatifFileService;

    private transient MultipartFile file;

    public void processFile(MealExpense mealExpense) {
        justificatifFileService.storeFile(mealExpense, this.file);
    }

    public void processFile(TransportExpense transportExpense) {
        justificatifFileService.storeFile(transportExpense, this.file);
    }

    public void processFile(AccommodationExpense accommodationExpense) {
        justificatifFileService.storeFile(accommodationExpense, this.file);
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
