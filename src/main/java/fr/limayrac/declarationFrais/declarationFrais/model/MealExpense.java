package fr.limayrac.declarationFrais.declarationFrais.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MealExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;
    private String justificatif;
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}


