package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ExpenseDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private java.sql.Date dateDeclaration;
    private String lieuFormation;
    private String intituleFormation;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<ExpenseDetail> expenseDetails;

    // getters and setters
}

