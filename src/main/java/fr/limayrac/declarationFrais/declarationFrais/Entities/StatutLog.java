package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class StatutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldStatut;
    private String newStatut;
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}

