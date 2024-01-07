package fr.limayrac.declarationFrais.declarationFrais.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TransportExpense")
public class TransportExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transportationType;
    private String departureLocation;
    private Double montant;
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}

