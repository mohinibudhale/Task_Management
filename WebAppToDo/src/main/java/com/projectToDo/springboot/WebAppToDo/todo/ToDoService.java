package com.projectToDo.springboot.WebAppToDo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<ToDo>();
	private static int todoCount = 0;
	static
	{
		todos.add(new ToDo(++todoCount,"Mona","Learn SpringBoot",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo(++todoCount,"Mona","Learn AWS",LocalDate.now().plusYears(2),false));
		todos.add(new ToDo(++todoCount,"Mona","Learn Hibernate",LocalDate.now().plusYears(2),false));
	}
	
	public List<ToDo> findByName(String name)
	{
		Predicate<? super ToDo> predicate = todo -> todo.getName().equalsIgnoreCase(name);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String name, String desc, LocalDate targetDate, boolean status)
	{
		ToDo todo = new ToDo(++todoCount,name,desc,targetDate,status);
		todos.add(todo);
	}
	
	public void deleteById(int id)
	{		 
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public ToDo findById(int id) 
	{
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo= todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);		
	}
	
}
