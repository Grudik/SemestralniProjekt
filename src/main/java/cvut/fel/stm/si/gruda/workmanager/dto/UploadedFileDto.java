/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dto;

/**
 *
 * @author GrudikNTB
 */
public class UploadedFileDto extends AbstractDto {
    String name;
    String note;
    Byte[] file;
    
    private Long project;
    private Long ticket;
    private Long workedHours;

    public UploadedFileDto(Long id, String name, String note, Byte[] file, Long project, Long ticket, Long workedHours) {
        super(id);
        this.name = name;
        this.note = note;
        this.file = file;
        this.project = project;
        this.ticket = ticket;
        this.workedHours = workedHours;
    }

    public UploadedFileDto() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Byte[] getFile() {
        return file;
    }

    public void setFile(Byte[] file) {
        this.file = file;
    }

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }

    public Long getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Long workedHours) {
        this.workedHours = workedHours;
    }
    
}
