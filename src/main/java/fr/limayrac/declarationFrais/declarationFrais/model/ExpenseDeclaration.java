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
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    private Instant dateValidation;
    private Instant created_at;
    private Instant updated_at;
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_bankDetails")
    private BankDetails bankDetails;

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<TransportExpense> transportExpenses = new ArrayList<>();

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<AccommodationExpense> accommodationExpenses = new ArrayList<>();

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<MealExpense> mealExpenses = new ArrayList<>();

    @OneToMany(mappedBy = "expenseDeclaration", cascade = CascadeType.ALL)
    private List<ExpenseLog> expenseLogs;

    public ExpenseDeclaration() {
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExpenseDeclaration{");

        stringBuilder.append("id=").append(id);
        stringBuilder.append(", dateDeclaration=").append(dateDeclaration);
        stringBuilder.append(", lieuFormation='").append(lieuFormation).append('\'');
        stringBuilder.append(", intituleFormation='").append(intituleFormation).append('\'');
        stringBuilder.append(", statut=").append(statut);
        stringBuilder.append(", dateValidation=").append(dateValidation);
        stringBuilder.append(", created_at=").append(created_at);
        stringBuilder.append(", updated_at=").append(updated_at);
        stringBuilder.append(", deleted=").append(deleted);

        if (user != null) {
            stringBuilder.append(", user=").append(user.getId());
        } else {
            stringBuilder.append(", user=null");
        }

        stringBuilder.append(", transportExpenses=").append(transportExpenses);
        stringBuilder.append(", accommodationExpenses=").append(accommodationExpenses);
        stringBuilder.append(", mealExpenses=").append(mealExpenses);
        stringBuilder.append(", expenseLogs=").append(expenseLogs);

        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    public void addTransportExpense(TransportExpense transportExpense) {
        if (this.transportExpenses == null) {
            this.setTransportExpenses(new ArrayList<>());
        }
        transportExpenses.add(transportExpense);
        transportExpense.setExpenseDeclaration(this);
    }

    public void addMealExpense(MealExpense mealExpense) {
        if (this.mealExpenses == null) {
            this.setMealExpenses(new ArrayList<>());
        }
        mealExpenses.add(mealExpense);
        mealExpense.setExpenseDeclaration(this);
    }

    public void addAccommodationExpense(AccommodationExpense accommodationExpense) {
        if (this.accommodationExpenses == null) {
            this.setAccommodationExpenses(new ArrayList<>());
        }
        accommodationExpenses.add(accommodationExpense);
        accommodationExpense.setExpenseDeclaration(this);
    }

    public AccommodationExpense getAccommodationExpense() {
        if (this.accommodationExpenses != null && this.accommodationExpenses.size() > 0) {
            return this.accommodationExpenses.get(0);
        }
        return null;
    }

    public TransportExpense getTransportExpenseById(Long id) {

        if (this.transportExpenses == null) {
            return null;
        }

        for (TransportExpense transportExpense : this.transportExpenses) {
            if (transportExpense.getId().equals(id)) {
                return transportExpense;
            }
        }

        return null;
    }



}

