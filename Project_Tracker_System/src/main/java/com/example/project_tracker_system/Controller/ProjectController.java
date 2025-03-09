package com.example.project_tracker_system.Controller;

import com.example.project_tracker_system.Api.ApiResponse;
import com.example.project_tracker_system.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/track")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    //GET
    @GetMapping("/get")
    public ArrayList<Project> getProjects() {
        return projects;
    }
    //ADD
    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Successfully added project");
    }
    @PutMapping("update/{index}")
    public ApiResponse updateProject(@RequestBody Project project , @PathVariable int index) {
        projects.set(index, project);
        return new ApiResponse("Successfully updated project");
    }
    //DELETE
    @DeleteMapping("/delete/{inddex}")
    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Successfully deleted project");
    }
    //SEARCH
    @GetMapping("/search/{title}")
    public Project searchProject(@PathVariable String title) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTitle().equalsIgnoreCase(title)) {
                return projects.get(i);
            }
        }
        return null;
    }
    //DISPLAY
    @GetMapping("/company/{companyName}")
    public ArrayList<Project> displayProjects(@PathVariable String companyName) {
        ArrayList<Project> display = new ArrayList<>();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getCompanyName().equalsIgnoreCase(companyName)) {
                display.add(projects.get(i));
            }
        }
        return display;
    }



}
