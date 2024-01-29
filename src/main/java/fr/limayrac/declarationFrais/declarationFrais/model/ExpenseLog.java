package fr.limayrac.declarationFrais.declarationFrais.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.time.Instant;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "expense_log")
@SQLRestriction("deleted=false")
public class ExpenseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montantTotal;
    private Double montantRepas;
    private Double montantLogement;
    private Double montantTransport;

    private String typeOperation;

    @Temporal(TemporalType.DATE)
    private Instant created_at;
    private Instant updated_at;
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    public ExpenseLog() {
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }

    public ExpenseLog(ExpenseDeclaration expenseDeclaration) {
        this.expenseDeclaration = expenseDeclaration;
        this.montantTotal = expenseDeclaration.getMontantTotal();
        this.montantRepas = expenseDeclaration.getMontantRepas();
        this.montantLogement = expenseDeclaration.getMontantLogement();
        this.montantTransport = expenseDeclaration.getMontantTransport();


        this.setTypeOperation("Create");



        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }
    // getters and setters
}


