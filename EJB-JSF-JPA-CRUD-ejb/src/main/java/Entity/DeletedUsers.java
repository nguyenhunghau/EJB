package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Sujan Maka
 */
@Entity(name = "DELETE_LIST")
@NamedQueries(
        {
            @NamedQuery(name = "allDeleteUsers", query = "SELECT d FROM DELETE_LIST d")
        })
public class DeletedUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DEL_REASON")
    private String delReason;
    @Column(name = "USERS_ID")
    private Long uId;
    @Column(name = "USER_NAME")
    private String uName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public DeletedUsers() {
    }
//getter and setters
}
