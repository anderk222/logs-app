package dev.anderk222.logs_app.domain.model;

import dev.anderk222.logs_app.domain.entity.Platform;

public class CompanyPlatform {
    private Long id;
    private Company company;
    private Platform platform;
    private String httpAddress;

    public CompanyPlatform(Long id, Company company, Platform platform, String httpAddress) {
        this.id = id;
        this.company = company;
        this.platform = platform;
        this.httpAddress = httpAddress;
    }

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getHttpAddress() {
        return httpAddress;
    }
}
