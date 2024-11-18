package Streams.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Client {
	public static void main(String[] args) {
		List<Student> students = insertStudents();
		for(Student std:students) {
			System.out.println("name " +std.getName());
			for(Subject sub:std.getSubjects()) {
				System.out.println("subject : "+sub.getSubjectName()+"  "+"marks : "+sub.getMarks());
			}
		}
		getMaxMarks("Physics",students);
	}

	private static void getMaxMarks(String subject,List<Student> students) {
		
		String name = students.stream().max(Comparator.comparingInt(
				std -> std.getSubjects().stream().filter(sub->sub.getSubjectName().equals(subject)).findFirst().get().getMarks()))
		.map(Student::getName).get();
		
		System.out.println("name :"+name);
		
	
		String stdName = students.stream()
			    .max(Comparator.comparingDouble(
			        std -> std.getSubjects().stream()
			            .mapToInt(Subject::getMarks)   // Extract marks for all subjects
			            .average().orElse(0.0)))        // Calculate the average marks
			    .map(Student::getName)                 // Get the student's name
			    .orElse("No students available"); 
		System.out.println(stdName);
		
//		students.stream()
//	    .max(Comparator.comparingDouble(
//	        std -> std.getSubjects().stream()
//	            .mapToInt(Subject::getMarks)
//	            .average().orElse(0.0))) // Calculate average marks
//	    .ifPresent(std -> {  // If a student with max average exists, print
//	        double avgMarks = std.getSubjects().stream()
//	            .mapToInt(Subject::getMarks)
//	            .average().orElse(0.0);  // Calculate average again for printing
//	        System.out.println("Name: " + std.getName() + ", Average Marks: " + avgMarks);
//	    });
		students.stream().max(Comparator.comparingDouble(
				std->std.getSubjects().stream().mapToInt(Subject::getMarks).average().orElse(0.0))).ifPresent(
						std -> {
							double avg = std.getSubjects().stream().mapToInt(Subject::getMarks).average().orElse(0.0);
							System.out.println("Name: " + std.getName() + ", Average Marks: " + avg);
						});
		
	}

	private static List<Student> insertStudents() {
		List<Student> std = new ArrayList<>();
		Student s1 = new Student();
		List<Subject> subjectList = new ArrayList<>();
		subjectList.add(new Subject("Maths", 100));
		subjectList.add(new Subject("Physics", 98));
		subjectList.add(new Subject("Chemistry", 95));
		subjectList.add(new Subject("Computer", 99));
		s1.setName("S1");
		s1.setSubjects(subjectList);
		Student s2 = new Student();
		List<Subject> subjectList1 = new ArrayList<>();
		subjectList1.add(new Subject("Maths", 80));
		subjectList1.add(new Subject("Physics", 100));
		subjectList1.add(new Subject("Chemistry", 99));
		subjectList1.add(new Subject("Computer", 89));
		s2.setName("S2");
		s2.setSubjects(subjectList1);
		
		Student s3 = new Student();
		List<Subject> subjectList2 = new ArrayList<>();
		subjectList2.add(new Subject("Maths", 95));
		subjectList2.add(new Subject("Physics", 70));
		subjectList2.add(new Subject("Chemistry", 89));
		subjectList2.add(new Subject("Computer", 96));
		s3.setName("S3");
		s3.setSubjects(subjectList2);
		
		Student s4 = new Student();
		List<Subject> subjectList3 = new ArrayList<>();
		subjectList3.add(new Subject("Maths", 100));
		subjectList3.add(new Subject("Physics", 80));
		subjectList3.add(new Subject("Chemistry", 79));
		subjectList3.add(new Subject("Computer", 94));
		s4.setName("S4");
		s4.setSubjects(subjectList3);
		
		Student s5 = new Student();
		List<Subject> subjectList4 = new ArrayList<>();
		subjectList4.add(new Subject("Maths", 100));
		subjectList4.add(new Subject("Physics", 80));
		subjectList4.add(new Subject("Chemistry", 79));
		subjectList4.add(new Subject("Computer", 94));
		s5.setName("S5");
		s5.setSubjects(subjectList4);
		std.add(s1);
		std.add(s2);
		std.add(s3);
		std.add(s4);
		std.add(s5);
		return std;
	}
}
