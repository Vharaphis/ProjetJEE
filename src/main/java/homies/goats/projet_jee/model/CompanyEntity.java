package homies.goats.projet_jee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company", schema = "projet_jee", catalog = "")
public class CompanyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCompany", nullable = false)
    private int idCompany;
    @Basic
    @Column(name = "socialReason", nullable = true, length = 255)
    private String socialReason;
    @Basic
    @Column(name = "companyAddress", nullable = true, length = 512)
    private String companyAddress;
    @Basic
    @Column(name = "companyInfos", nullable = true, length = -1)
    private String companyInfos;

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyInfos() {
        return companyInfos;
    }

    public void setCompanyInfos(String companyInfos) {
        this.companyInfos = companyInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (idCompany != that.idCompany) return false;
        if (socialReason != null ? !socialReason.equals(that.socialReason) : that.socialReason != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (companyInfos != null ? !companyInfos.equals(that.companyInfos) : that.companyInfos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompany;
        result = 31 * result + (socialReason != null ? socialReason.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (companyInfos != null ? companyInfos.hashCode() : 0);
        return result;
    }
}
