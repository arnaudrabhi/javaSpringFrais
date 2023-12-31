package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class ExpenseDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDeclaration;
    private String lieuFormation;
    private int statut;
    private Date dateCreation;
    private Date dateValidation;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<TransportExpense> transportExpenses;

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<AccommodationExpense> accommodationExpenses;

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<MealExpense> mealExpenses;

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<ExpenseLog> expenseLogs;

    // autres attributs et getters and setters
}

