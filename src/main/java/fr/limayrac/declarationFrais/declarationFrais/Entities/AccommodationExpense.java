package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "AccommodationExpense")
public class AccommodationExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accomodationType;
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}

