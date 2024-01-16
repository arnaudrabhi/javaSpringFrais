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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("deleted=false")
@Table(name = "transport_expenses")
public class TransportExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transportationType;
    private String departureLocation;
    private Double montant;
    private Instant created_at;
    private Instant updated_at;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}

