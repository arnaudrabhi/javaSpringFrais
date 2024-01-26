package fr.limayrac.declarationFrais.declarationFrais.service;

import fr.limayrac.declarationFrais.declarationFrais.model.TransportExpense;
import fr.limayrac.declarationFrais.declarationFrais.repository.TransportExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("transportExpenseService")
public class TransportExpenseService {

    private final TransportExpenseRepository transportExpenseRepository;

    @Autowired
    public TransportExpenseService(TransportExpenseRepository transportExpenseRepository) {
        this.transportExpenseRepository = transportExpenseRepository;
    }

    public Optional<TransportExpense> getTransportExpenseById(Long id) {
        return transportExpenseRepository.findById(id);
    }

    public TransportExpense saveTransportExpense(TransportExpense transportExpense) {
        // Add any additional logic or validation here before saving
        return transportExpenseRepository.save(transportExpense);
    }

    public void deleteTransportExpense(Long id) {
        transportExpenseRepository.deleteById(id);
    }
}
