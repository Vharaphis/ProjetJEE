package homies.goats.projetjee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entreprise", schema = "projet_jee", catalog = "")
public class EntrepriseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEntreprise", nullable = false)
    private int idEntreprise;
    @Basic
    @Column(name = "socialReason", nullable = true, length = 255)
    private String socialReason;
    @Basic
    @Column(name = "entrepriseAddress", nullable = true, length = 512)
    private String entrepriseAddress;
    @Basic
    @Column(name = "entrepriseInfos", nullable = true, length = -1)
    private String entrepriseInfos;

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getEntrepriseAddress() {
        return entrepriseAddress;
    }

    public void setEntrepriseAddress(String entrepriseAddress) {
        this.entrepriseAddress = entrepriseAddress;
    }

    public String getEntrepriseInfos() {
        return entrepriseInfos;
    }

    public void setEntrepriseInfos(String entrepriseInfos) {
        this.entrepriseInfos = entrepriseInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntrepriseEntity that = (EntrepriseEntity) o;

        if (idEntreprise != that.idEntreprise) return false;
        if (socialReason != null ? !socialReason.equals(that.socialReason) : that.socialReason != null) return false;
        if (entrepriseAddress != null ? !entrepriseAddress.equals(that.entrepriseAddress) : that.entrepriseAddress != null)
            return false;
        if (entrepriseInfos != null ? !entrepriseInfos.equals(that.entrepriseInfos) : that.entrepriseInfos != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEntreprise;
        result = 31 * result + (socialReason != null ? socialReason.hashCode() : 0);
        result = 31 * result + (entrepriseAddress != null ? entrepriseAddress.hashCode() : 0);
        result = 31 * result + (entrepriseInfos != null ? entrepriseInfos.hashCode() : 0);
        return result;
    }
}
