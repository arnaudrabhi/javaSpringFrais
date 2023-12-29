package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp logDate;
    private String eventType; // Connexion, Déconnexion, Création, Modification, Suppression, Erreur
    private Long userId; // Identifiant de l'utilisateur concerné
    private String declarationAction; // Action sur la déclaration (si applicable)
    private String errorMessage; // Message d'erreur (si applicable)

    // getters and setters
}
