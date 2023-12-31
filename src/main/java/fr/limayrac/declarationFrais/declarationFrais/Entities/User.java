package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String role;
    private String email;
    @Column(nullable = false, length = 255)
    private String password;



    // getters and setters

    @OneToMany(mappedBy = "user")
    private List<ExpenseDeclaration> expenseDeclarations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BankDetails> bankDetails;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ExpenseDeclaration> getExpenseDeclarations() {
        return expenseDeclarations;
    }

    public void setExpenseDeclarations(List<ExpenseDeclaration> expenseDeclarations) {
        this.expenseDeclarations = expenseDeclarations;
    }

    public List<BankDetails> getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(List<BankDetails> bankDetails) {
        this.bankDetails = bankDetails;
    }
}
