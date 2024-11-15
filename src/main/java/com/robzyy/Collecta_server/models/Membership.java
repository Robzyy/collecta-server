package com.robzyy.Collecta_server.models;

import java.util.Date;

public class Membership {
    private String id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private RecurrencePattern recurrencePattern;
    private Double cost;
    private String currency;
    private String userId;
    private Date createdAt;
    private Date updatedAt;

    public Membership() {}

    public Membership(String name, String desc, Date startDate, RecurrencePattern recurrencePattern, Double cost, String currency, String userId){
        this.id = name;
        this.title = name;
        this.description = desc;
        this.startDate = startDate;
        this.endDate = new Date(startDate.getTime() + 191237124);
        this.createdAt = startDate;
        this.updatedAt = startDate;
        this.recurrencePattern =  recurrencePattern;
        this.cost = cost;
        this.userId = userId;
        this.currency = currency;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public RecurrencePattern getRecurrencePattern() { return recurrencePattern; }
    public void setRecurrencePattern(RecurrencePattern recurrencePattern) { this.recurrencePattern = recurrencePattern; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
} 