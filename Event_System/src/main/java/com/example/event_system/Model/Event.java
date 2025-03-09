package com.example.event_system.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Event {
    private int id;
    private String description;
    private double capacity;
    private LocalDate startDate;
    private LocalDate endDate;
}
