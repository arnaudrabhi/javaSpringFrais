package fr.limayrac.declarationFrais.declarationFrais.model;

import fr.limayrac.declarationFrais.declarationFrais.enums.statutDeclaration;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense_declaration")
@SQLRestriction("deleted=false")
public class ExpenseDeclaration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant dateDeclaration;
    private String lieuFormation;
    private String intituleFormation;

    @Enumerated(EnumType.STRING)
    private statutDeclaration statut;
    private Instant dateCreation;
    private Instant dateValidation;
    private Instant created_at;
    private Instant updated_at;
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

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

    public void addTransportExpense(TransportExpense transportExpense) {
        transportExpenses.add(transportExpense);
        transportExpense.setExpenseDeclaration(this);
    }

    public void addMealExpense(MealExpense mealExpense) {
        mealExpenses.add(mealExpense);
        mealExpense.setExpenseDeclaration(this);
    }

}

