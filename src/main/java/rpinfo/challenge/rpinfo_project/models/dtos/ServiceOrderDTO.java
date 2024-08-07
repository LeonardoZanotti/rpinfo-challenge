package rpinfo.challenge.rpinfo_project.models.dtos;

public class ServiceOrderDTO {

    private Long clientId;
    private Long equipmentId;
    private String description;

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getEquipmentId() {
        return equipmentId;
    }
    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
