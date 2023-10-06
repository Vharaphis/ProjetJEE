package homies.goats.projetjee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback", schema = "projet_jee", catalog = "")
public class FeedbackEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFeedback", nullable = false)
    private int idFeedback;
    @Basic
    @Column(name = "feedback", nullable = true, length = -1)
    private String feedback;
    @Basic
    @Column(name = "idApprentice", nullable = true)
    private Integer idApprentice;

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getIdApprentice() {
        return idApprentice;
    }

    public void setIdApprentice(Integer idApprentice) {
        this.idApprentice = idApprentice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (idFeedback != that.idFeedback) return false;
        if (feedback != null ? !feedback.equals(that.feedback) : that.feedback != null) return false;
        if (idApprentice != null ? !idApprentice.equals(that.idApprentice) : that.idApprentice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFeedback;
        result = 31 * result + (feedback != null ? feedback.hashCode() : 0);
        result = 31 * result + (idApprentice != null ? idApprentice.hashCode() : 0);
        return result;
    }
}
