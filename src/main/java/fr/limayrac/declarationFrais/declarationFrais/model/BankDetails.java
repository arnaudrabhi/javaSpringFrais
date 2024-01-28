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
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "bank_details")
@SQLRestriction("deleted=false")
public class BankDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEnregistrement;
    private String nomCompte;
    private String prenomCompte;
    private String IBAN;
    private String nomBanque;
    private Instant created_at;
    private Instant updated_at;
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;

    @OneToMany
    @JoinColumn(name = "id_ExpenseDeclaration", unique = true)
    private List<ExpenseDeclaration> expenseDeclarations = new ArrayList<>();

    public String toString() {
        return nomEnregistrement + " | " + nomBanque + " | " + IBAN;
    }

    public BankDetails() {
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }
    // getters and setters
}


