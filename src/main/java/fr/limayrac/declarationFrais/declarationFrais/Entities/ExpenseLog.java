package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class ExpenseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp eventDate;
    private String eventType;
    private Long declarationId;
    private Long professorId;
    private String oldStatus;
    private String newStatus;
    private Double totalAmount;

    // getters and setters
}

