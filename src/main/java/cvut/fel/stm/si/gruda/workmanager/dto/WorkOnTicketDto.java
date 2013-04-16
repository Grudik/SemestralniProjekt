/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dto;

/**
 *
 * @author GrudikNTB
 */
public class WorkOnTicketDto extends AbstractDto {
    
    private boolean ownerOfTicket;
    private Long user;
    private Long ticket;

    public WorkOnTicketDto(Long id, boolean ownerOfTicket, Long user, Long ticket) {
        super(id);
        this.ownerOfTicket = ownerOfTicket;
        this.user = user;
        this.ticket = ticket;
    }

    public WorkOnTicketDto() {
        
    }

    public boolean isOwnerOfTicket() {
        return ownerOfTicket;
    }

    public void setOwnerOfTicket(boolean ownerOfTicket) {
        this.ownerOfTicket = ownerOfTicket;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }
    
}
