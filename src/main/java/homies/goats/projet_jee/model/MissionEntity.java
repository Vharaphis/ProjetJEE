package homies.goats.projet_jee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mission", schema = "projet_jee", catalog = "")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMission", nullable = false)
    private int idMission;
    @Basic
    @Column(name = "keyWords", nullable = true, length = 255)
    private String keyWords;
    @Basic
    @Column(name = "targetedJob", nullable = true, length = 255)
    private String targetedJob;
    @Basic
    @Column(name = "comments", nullable = true, length = -1)
    private String comments;
    @Basic
    @Column(name = "idEntreprise", nullable = true)
    private Integer idEntreprise;

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getTargetedJob() {
        return targetedJob;
    }

    public void setTargetedJob(String targetedJob) {
        this.targetedJob = targetedJob;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (idMission != that.idMission) return false;
        if (keyWords != null ? !keyWords.equals(that.keyWords) : that.keyWords != null) return false;
        if (targetedJob != null ? !targetedJob.equals(that.targetedJob) : that.targetedJob != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (idEntreprise != null ? !idEntreprise.equals(that.idEntreprise) : that.idEntreprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMission;
        result = 31 * result + (keyWords != null ? keyWords.hashCode() : 0);
        result = 31 * result + (targetedJob != null ? targetedJob.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (idEntreprise != null ? idEntreprise.hashCode() : 0);
        return result;
    }
}
