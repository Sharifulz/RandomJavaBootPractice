package com.exam.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.exam.oop.Project;

public class FilterFromList {

	public static void main(String[] args) {
		List<Project> projectList = new ArrayList<Project>();
		List<Project> projectListSorted = new ArrayList<Project>();
		projectList = pushProjectData();
		
		System.out.println("------------------------------- Current List -------------------------------------");
		for (Project project : projectList) {
			System.out.println(project.toString());
		}
		
		List<Project> personListFiltered = projectList.stream() 
				  .filter(distinctByKey(p -> p.getProjectCode())) 
				  .collect(Collectors.toList());
		System.out.println("------------------------------- Filtered by Project Code List -------------------------------------");
		for (Project project : personListFiltered) {
			System.out.println(project.toString());
		}
		
		Comparator<Project> sortCompartor = Comparator
				.comparing(Project::getProjectCode)
				.thenComparing(Project::getCompanyCode);
		
		projectListSorted = projectList.stream()
                .sorted(sortCompartor.reversed())
                .collect(Collectors.toList());
		System.out.println("------------------------------- Sorted List -------------------------------------");
		for (Project project : projectListSorted) {
			System.out.println(project.toString());
		}
		
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		   
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
}

	public static List<Project> pushProjectData() {
		Project p1 = new Project("BDA", "BDAWIFI", "Bangladesh Army Wifi Project");
		Project p2 = new Project("BDA", "BDAWIFI", "Bangladesh Army Wifi Project");
		Project p3 = new Project("CTS", "BDAWIFI", "CTrends Software Limited");
		Project p4 = new Project("BDA", "SURVEY", "Bangladesh Army Survey Project");
		Project p5 = new Project("BDA", "BDAWIFI", "Bangladesh Army Wifi Project");
		
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
		projectList.add(p4);
		projectList.add(p5);
		
		return projectList;
		
	}
	
}
