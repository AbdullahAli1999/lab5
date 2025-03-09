package com.example.project_tracker_system.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;

}
