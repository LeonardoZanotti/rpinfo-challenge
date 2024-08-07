package rpinfo.challenge.rpinfo_project.models.dtos;

public class TrackingDTO {

    private Long serviceOrderId;
    private String description;
    
    public Long getServiceOrderId() {
        return serviceOrderId;
    }
    public void setServiceOrderId(Long serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
