package fr.limayrac.declarationFrais.declarationFrais.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ExpenseLog")
public class ExpenseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montantTotal;
    private Double montantRepas;
    private Double montantLogement;
    private Double montantTransport;
    private Date typeLogement;
    private Date TypeTransport;

    @Temporal(TemporalType.DATE)
    private Date created_ta;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}


