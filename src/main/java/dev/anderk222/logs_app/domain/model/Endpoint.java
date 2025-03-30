package dev.anderk222.logs_app.domain.model;

public class Endpoint {
    private Long id;
    private String name;
    private String description;
    private String path;
    private String type;

    public Endpoint(Long id, String name, String description, String path, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
