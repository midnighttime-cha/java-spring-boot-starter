package com.kaikannook.mytodo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
  private List<Todo> todos = new ArrayList<>();

  public TodoController() {
    todos.add(new Todo(1, "หรอย"));
    todos.add(new Todo(2, "หม้ายละน้อง"));
    todos.add(new Todo(3, "มาดถานนิ"));
  }

  @GetMapping("/todo")
  public List<Todo> getTodos1() {
    return todos;
  }

  @GetMapping("/todo/{id}")
  public Todo getTodoByIds(@PathVariable long id) {
    return todos.stream()
        .filter(result -> result.getId() == id)
        .findFirst()
        .orElseGet(() -> null);
  }

  @GetMapping("/todo/search")
  public String getTodoByName(@RequestParam(defaultValue = "Cat") String name) {
    return name;
  }
}
