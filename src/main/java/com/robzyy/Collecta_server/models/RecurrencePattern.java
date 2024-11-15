package com.robzyy.Collecta_server.models;

import java.util.Date;

public class RecurrencePattern {
    private FrequencyType frequency; // Will be constrained to specific values
    private int interval;
    private int endAfterOccurrences;
    private Date endByDate;

    public RecurrencePattern(FrequencyType frequency, int interval, int  endAfterOccurrences, Date endByDate){
        this.frequency = frequency;
        this.interval = interval;
        this.endAfterOccurrences = endAfterOccurrences;
        this.endByDate = endByDate;
    }

    // Getters and Setters
    public FrequencyType getFrequency() { return frequency; }
    public void setFrequency(FrequencyType frequency) { this.frequency = frequency; }
    
    public int getInterval() { return interval; }
    public void setInterval(int interval) { this.interval = interval; }
    
    public int getEndAfterOccurrences() { return endAfterOccurrences; }
    public void setEndAfterOccurrences(int endAfterOccurrences) { this.endAfterOccurrences = endAfterOccurrences; }
    
    public Date getEndByDate() { return endByDate; }
    public void setEndByDate(Date endByDate) { this.endByDate = endByDate; }
} 