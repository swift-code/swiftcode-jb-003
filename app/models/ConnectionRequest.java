package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by lubuntu on 10/22/16.
 */
@Entity
public class ConnectionRequest extends Model{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    @ManyToOne
    public User sender;
    @ManyToOne
    public User receiver;
    public Status status;
    public enum Status{
        //@EnumValue(value="WAITING")
        WAITING,
        ACCEPTED

    }
    public static Model.Finder<Long,ConnectionRequest> find = new Model.Finder<Long,ConnectionRequest>(ConnectionRequest.class);
}
