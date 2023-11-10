package homies.goats.projet_jee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "visit", schema = "projet_jee", catalog = "")
public class VisitEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idVisit", nullable = false)
    private int idVisit;
    @Basic
    @Column(name = "dateVisit", nullable = true, length = 10)
    private String dateVisit;
    @Basic
    @Column(name = "formatVisit", nullable = true, length = 255)
    private String formatVisit;
    @Basic
    @Column(name = "deliveredComponent", nullable = true, length = -1)
    private String deliveredComponent;
    @Basic
    @Column(name = "idApprentice", nullable = true)
    private Integer idApprentice;
    @Basic
    @Column(name = "idTutor", nullable = true)
    private Integer idTutor;

    public int getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    public String getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(String dateVisit) {
        this.dateVisit = dateVisit;
    }

    public String getFormatVisit() {
        return formatVisit;
    }

    public void setFormatVisit(String formatVisit) {
        this.formatVisit = formatVisit;
    }

    public String getDeliveredComponent() {
        return deliveredComponent;
    }

    public void setDeliveredComponent(String deliveredComponent) {
        this.deliveredComponent = deliveredComponent;
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

        VisitEntity that = (VisitEntity) o;

        if (idVisit != that.idVisit) return false;
        if (dateVisit != null ? !dateVisit.equals(that.dateVisit) : that.dateVisit != null) return false;
        if (formatVisit != null ? !formatVisit.equals(that.formatVisit) : that.formatVisit != null) return false;
        if (deliveredComponent != null ? !deliveredComponent.equals(that.deliveredComponent) : that.deliveredComponent != null)
            return false;
        if (idApprentice != null ? !idApprentice.equals(that.idApprentice) : that.idApprentice != null) return false;
        if (idTutor != null ? !idTutor.equals(that.idTutor) : that.idTutor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisit;
        result = 31 * result + (dateVisit != null ? dateVisit.hashCode() : 0);
        result = 31 * result + (formatVisit != null ? formatVisit.hashCode() : 0);
        result = 31 * result + (deliveredComponent != null ? deliveredComponent.hashCode() : 0);
        result = 31 * result + (idApprentice != null ? idApprentice.hashCode() : 0);
        result = 31 * result + (idTutor != null ? idTutor.hashCode() : 0);
        return result;
    }
}
