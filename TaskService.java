package com.manager.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manager.repository.TaskRepository;
import com.manager.entity.Tasks;


@Service
public class TaskService implements Service_Tasks{
	
	@Autowired
	TaskRepository trep;
	
	@Override
	 public String addTask(Tasks task) {
	        trep.save(task);
			return "task saved";
	     
	    }
	
	@Override
	    public String removeTask(String title) {
	    Tasks task = trep.findByTitle(title); 
		trep.delete(task);

		return "task removed";
	    }
	
	@Override
	public List<Tasks> getTasks() {
	    List<Tasks> incomplete = trep.findByCompleted(false);
	    sortByPriority(incomplete);

	    return incomplete;
	}

	
	private void sortByPriority(List<Tasks> tasks) 
	{
	    Map<String, Integer> order = new HashMap<>();
	    order.put("HIGH", 3);
	    order.put("MEDIUM", 2);
	    order.put("LOW", 1);

	    Collections.sort(tasks, new Comparator<Tasks>() {
	        @Override
	        public int compare(Tasks task1, Tasks task2) {
	            Integer priority1 = order.getOrDefault(task1.getPriority(), 0);
	            Integer priority2 = order.getOrDefault(task2.getPriority(), 0);
	            
	            return priority2.compareTo(priority1);
	        }
	    });
	}



	@Override
	public String addToComplete(String title) {
		Tasks task = trep.findByTitle(title);
		 task.setCompleted(true);
		trep.save(task);
		return "task saved in completed list";
	}
	
	@Override
	public List<Tasks> getCompletedTasks() {
        return trep.findByCompleted(true);
    }

}
