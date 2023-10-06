package homies.goats.projetjee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apprentice", schema = "projet_jee", catalog = "")
public class ApprenticeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idApprentice", nullable = false)
    private int idApprentice;
    @Basic
    @Column(name = "programme", nullable = true, length = 255)
    private String programme;
    @Basic
    @Column(name = "anneeAcademique", nullable = true, length = 255)
    private String anneeAcademique;
    @Basic
    @Column(name = "majeure", nullable = true, length = 255)
    private String majeure;
    @Basic
    @Column(name = "idEntreprise", nullable = true)
    private Integer idEntreprise;
    @Basic
    @Column(name = "idTutor", nullable = true)
    private Integer idTutor;
    @Basic
    @Column(name = "userID", nullable = true)
    private Integer userId;

    public int getIdApprentice() {
        return idApprentice;
    }

    public void setIdApprentice(int idApprentice) {
        this.idApprentice = idApprentice;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public String getMajeure() {
        return majeure;
    }

    public void setMajeure(String majeure) {
        this.majeure = majeure;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenticeEntity that = (ApprenticeEntity) o;

        if (idApprentice != that.idApprentice) return false;
        if (programme != null ? !programme.equals(that.programme) : that.programme != null) return false;
        if (anneeAcademique != null ? !anneeAcademique.equals(that.anneeAcademique) : that.anneeAcademique != null)
            return false;
        if (majeure != null ? !majeure.equals(that.majeure) : that.majeure != null) return false;
        if (idEntreprise != null ? !idEntreprise.equals(that.idEntreprise) : that.idEntreprise != null) return false;
        if (idTutor != null ? !idTutor.equals(that.idTutor) : that.idTutor != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprentice;
        result = 31 * result + (programme != null ? programme.hashCode() : 0);
        result = 31 * result + (anneeAcademique != null ? anneeAcademique.hashCode() : 0);
        result = 31 * result + (majeure != null ? majeure.hashCode() : 0);
        result = 31 * result + (idEntreprise != null ? idEntreprise.hashCode() : 0);
        result = 31 * result + (idTutor != null ? idTutor.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
