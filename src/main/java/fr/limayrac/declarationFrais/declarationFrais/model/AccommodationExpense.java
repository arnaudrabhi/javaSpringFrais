package fr.limayrac.declarationFrais.declarationFrais.model;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "accomodation_expense")
@SQLRestriction("deleted=false")
public class AccommodationExpense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accomodationType;
    private Double montant;
    private Instant created_at;
    private Instant updated_at;

    @ManyToOne
    @JoinColumn(name = "justificatif_id")
    private JustificatifFile justificatif;
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    public AccommodationExpense() {
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }

    // getters and setters
}

