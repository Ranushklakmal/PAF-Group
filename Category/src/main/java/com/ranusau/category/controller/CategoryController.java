package com.ranusau.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ranusau.category.exception.ResourceNotFoundException;
import com.ranusau.category.model.Category;
import com.ranusau.category.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAllNotes() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public Category createNote(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/categories/{id}")
    public Category getNoteById(@PathVariable(value = "id") Long catId) {
        return categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", catId));
    }

    @PutMapping("/categories/{id}")
    public Category updateNote(@PathVariable(value = "id") Long catId,
                                           @Valid @RequestBody Category catDetails) {

        Category category = categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", catId));

        category.setTitle(catDetails.getTitle());
        category.setContent(catDetails.getContent());

        Category updatedCat = categoryRepository.save(category);
        return updatedCat;
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable(value = "id") Long catId) {
        Category category = categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", catId));

        categoryRepository.delete(category);

        return ResponseEntity.ok().build();
    }
}
