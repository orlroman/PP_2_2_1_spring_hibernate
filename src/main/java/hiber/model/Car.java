package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "series", referencedColumnName = "id")
    private User user;
    
    @Column(name = "model")
    private String model;
    
    public Car() {
    }
    
    public Car(String model) {
        this.model = model;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
}
