package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.entity.Tasks;
import com.manager.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService tserv;
	
	@GetMapping("/main")
	public String redirect()
	{
		System.out.println("control in redirect");
		return "index";
			
	}
	
	@PostMapping("/addTasks")
	public String addTasks(Model model,@ModelAttribute Tasks tasks)
	{
		System.out.println("control in addtasks");
		String msg = tserv.addTask(tasks);
		System.out.println(msg);
		
		return "addition";
		
	}
	
	@PostMapping("/remove")
	public String removeTask(Model model,@RequestParam String title)
	{
		System.out.println("control in removetask");

		tserv.removeTask(title);
		System.out.println("task removed");
		return "display";
	}
	
	@GetMapping("/getTasks")
	public String display(Model model)
	{
		System.out.println("control in display");

		List<Tasks> tasks = tserv.getTasks();
		 model.addAttribute("tasks", tasks);
		return "display";
		
	}
	
	@PostMapping("/complete")
	public String completedTasks(Model model,@RequestParam String title)
	{
		System.out.println("control in completed tasks");

		String msg = tserv.addToComplete(title);
		System.out.println(msg);
		 return "completed";

	}
	
	@GetMapping("/finished")
	public String showCompleted(Model model)
	{
		System.out.println("control in show completed");

		List<Tasks> tasks = tserv.getCompletedTasks();
		 model.addAttribute("tasks", tasks);
		 return "completed";
	}
}
