/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Grudik-stolni
 */

@Entity
public class WorkOnTicket extends AbstractBusinessObject {
   private boolean owner;
   
   @ManyToOne
   private User user;
   
   @ManyToOne
   private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }
   
   
}
