package Controller;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sujan Maka
 */
@ManagedBean
@ViewScoped
public class DataFilteringBean implements Serializable {

    private static final long serialVersionUID = -5680001353441022183L;
    private String name;
    private String mobile;
    private String email;
    
    //getter and setters
}