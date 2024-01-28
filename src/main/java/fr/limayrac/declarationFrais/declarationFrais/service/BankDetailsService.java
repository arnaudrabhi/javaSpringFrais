// BankDetailsService.java
package fr.limayrac.declarationFrais.declarationFrais.service;

import fr.limayrac.declarationFrais.declarationFrais.model.BankDetails;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import fr.limayrac.declarationFrais.declarationFrais.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService {

    private final BankDetailsRepository bankDetailsRepository;

    @Autowired
    public BankDetailsService(BankDetailsRepository bankDetailsRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
    }

    public List<BankDetails> getBankByUser(User user) {
        return bankDetailsRepository.getByUser(user);
    }

    public List<BankDetails> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }

    public Optional<BankDetails> getBankDetailsById(Long id) {
        return bankDetailsRepository.findById(id);
    }

    public BankDetails saveBankDetails(BankDetails bankDetails) {
        return bankDetailsRepository.save(bankDetails);
    }

    public void deleteBankDetails(Long id) {
        bankDetailsRepository.deleteById(id);
    }
}
