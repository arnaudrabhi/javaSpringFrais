package fr.limayrac.declarationFrais.declarationFrais.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.sql.Date;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "statut_log")
@SQLRestriction("deleted=false")
public class StatutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldStatut;
    private String newStatut;
    private Instant created_at;
    private Instant updated_at;

    @ManyToOne
    @JoinColumn(name = "id_ExpenseDeclaration")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}

