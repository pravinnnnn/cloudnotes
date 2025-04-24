package com.cloudnotes.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private List<String> notes = new ArrayList<>();

    @GetMapping
    public List<String> getNotes() {
        return notes;
    }

    @PostMapping
    public String addNote(@RequestBody String note) {
        notes.add(note);
        return "Note added.";
    }

    @DeleteMapping("/{index}")
    public String deleteNote(@PathVariable int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            return "Note deleted.";
        }
        return "Invalid index.";
    }
}
