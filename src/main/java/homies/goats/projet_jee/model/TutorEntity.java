package homies.goats.projet_jee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tutor", schema = "projet_jee", catalog = "")
public class TutorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTutor", nullable = false)
    private int idTutor;
    @Basic
    @Column(name = "userID", nullable = true)
    private Integer userId;

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
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

        TutorEntity that = (TutorEntity) o;

        if (idTutor != that.idTutor) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTutor;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
