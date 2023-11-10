package homies.goats.projet_jee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apprentice", schema = "projet_jee", catalog = "")
public class ApprenticeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idApprentice", nullable = false)
    private int idApprentice;
    @Basic
    @Column(name = "program", nullable = true, length = 255)
    private String program;
    @Basic
    @Column(name = "academicYear", nullable = true, length = 255)
    private String academicYear;
    @Basic
    @Column(name = "major", nullable = true, length = 255)
    private String major;
    @Basic
    @Column(name = "isArchived")
    private Boolean isArchived;
    @Basic
    @Column(name = "idCompany", nullable = true)
    private Integer idCompany;
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
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
        if (program != null ? !program.equals(that.program) : that.program != null) return false;
        if (academicYear != null ? !academicYear.equals(that.academicYear) : that.academicYear != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (idCompany != null ? !idCompany.equals(that.idCompany) : that.idCompany != null) return false;
        if (idTutor != null ? !idTutor.equals(that.idTutor) : that.idTutor != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idApprentice;
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (academicYear != null ? academicYear.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (idCompany != null ? idCompany.hashCode() : 0);
        result = 31 * result + (idTutor != null ? idTutor.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
