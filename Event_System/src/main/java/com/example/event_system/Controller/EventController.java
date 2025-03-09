package com.example.event_system.Controller;

import com.example.event_system.Api.ApiResponse;
import com.example.event_system.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    //GET
    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }
    //ADD
    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Successfully added event");

    }
    //UPDATE
    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@RequestBody Event event , @PathVariable int index) {
       events.set(index, event);
       return new ApiResponse("Successfully updated event");
    }
    //DELETE
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Successfully deleted event");
    }

    @PutMapping("/{id}/capacity/{newCapacity}")
    public String changeCapacity(@PathVariable int id, @PathVariable double newCapacity) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == id) {
                events.get(i).setCapacity(newCapacity);
                return "Successfully updated event";
            }

        }
        return "Event not found";

    }

    @GetMapping("/search/{id}")
    public Event searchEvents(@PathVariable int id) {
        for (int i = 0; i < events.size(); i++) {
          Event  event = events.get(i);
            if (event.getId() == id) {
                return event;
            }
        }
        return null;

    }




}
