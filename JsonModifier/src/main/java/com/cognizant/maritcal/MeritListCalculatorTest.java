package com.cognizant.maritcal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeritListCalculatorTest {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		Student ravi = new Student("Ravi", "KARNATAKA", 70f);
		Student rama = new Student("Rama", "PUNE", 50f);
		Student vinod = new Student("vinod", "CBSE", 85f);
		Student sahid = new Student("Sahid", "MUMBAI", 78f);
		Student sahwan = new Student("Sahwan", "TELANGANA", 49f);
		Student mahesh = new Student("Mahesh", "CBSE", 61f);
		Student sourabh = new Student("Sourabh", "DELHI", 37f);
		
		students.add(ravi);
		students.add(rama);
		students.add(vinod);
		students.add(sahid);
		students.add(sahwan);
		students.add(mahesh);
		students.add(sourabh);
		
		List<Student> meritStudents = meritListCounter(students);
		System.out.println(meritStudents);
		
	}

	@SuppressWarnings("unchecked")
	private static List<Student> meritListCounter(List<Student> students){
		
		List<Student> studentList =  weightageCalculator(students);
		List<Student> maritStudentList = new ArrayList<Student>();
		Collections.sort(studentList, new MarksComparator());
		
		for(int i=0 ; i < 4 ; i++) {
			if(studentList.get(i)!=null)
				maritStudentList.add(studentList.get(i));		
		}
		return maritStudentList;
		
	}
	
	private static List<Student> weightageCalculator(List<Student> students){
		List<Student> updatedStudentList = new ArrayList<Student>();
		for(Student temp : students) {
			
			if("CBSE".equalsIgnoreCase(temp.getBoard())) {
				updatedStudentList.add(temp);
				temp.setMarks(temp.getMarks() + temp.getMarks() * 0.08f);
			}
			if("KARNATAKA".equalsIgnoreCase(temp.getBoard())) {
				updatedStudentList.add(temp);
				temp.setMarks(temp.getMarks() + temp.getMarks()* 0.07f);
			}
			if("TELANGANA".equalsIgnoreCase(temp.getBoard())) {
				updatedStudentList.add(temp);
				temp.setMarks(temp.getMarks() + temp.getMarks()* 0.07f);
			}
			if("DELHI".equalsIgnoreCase(temp.getBoard())) {
				updatedStudentList.add(temp);
				temp.setMarks(temp.getMarks() + temp.getMarks() * 0.07f);
			}
			if("PUNE".equalsIgnoreCase(temp.getBoard())) {
				updatedStudentList.add(temp);
				temp.setMarks(temp.getMarks() + temp.getMarks() * 0.06f);
			}
		}
		
		return updatedStudentList;
	}

	}


