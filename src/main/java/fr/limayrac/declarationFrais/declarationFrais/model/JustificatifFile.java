package fr.limayrac.declarationFrais.declarationFrais.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "justificatifs")
public class JustificatifFile implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    private String fileName;
    private String fileType;
    private Instant created_at;
    private Instant updated_at;

    @Lob
    @Column(name = "data", columnDefinition="BLOB")
    private byte[] data;

    public JustificatifFile() {
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }

    public JustificatifFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(UUID id) {
        this.id = (id);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}