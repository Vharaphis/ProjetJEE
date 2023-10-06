package homies.goats.projetjee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluation", schema = "projet_jee", catalog = "")
public class EvaluationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEvaluation", nullable = false)
    private int idEvaluation;
    @Basic
    @Column(name = "grade", nullable = true)
    private Integer grade;
    @Basic
    @Column(name = "comments", nullable = true, length = -1)
    private String comments;
    @Basic
    @Column(name = "idApprentice", nullable = true)
    private Integer idApprentice;
    @Basic
    @Column(name = "idTutor", nullable = true)
    private Integer idTutor;

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getIdApprentice() {
        return idApprentice;
    }

    public void setIdApprentice(Integer idApprentice) {
        this.idApprentice = idApprentice;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationEntity that = (EvaluationEntity) o;

        if (idEvaluation != that.idEvaluation) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (idApprentice != null ? !idApprentice.equals(that.idApprentice) : that.idApprentice != null) return false;
        if (idTutor != null ? !idTutor.equals(that.idTutor) : that.idTutor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvaluation;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (idApprentice != null ? idApprentice.hashCode() : 0);
        result = 31 * result + (idTutor != null ? idTutor.hashCode() : 0);
        return result;
    }
}
