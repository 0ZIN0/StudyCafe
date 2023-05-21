package dto;
//연습용 클래스. 나중에 지우기
public class temDTO {
    private String id;
    private String description;

    // 생성자
    public temDTO(String id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getter와 Setter 메서드
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}