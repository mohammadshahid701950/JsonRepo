package com.cognizant.maritcal;

import java.util.Comparator;

public class MarksComparator implements Comparator{
	public int compare(Object o1,Object o2){  
		Student s1=(Student)o1;  
		Student s2=(Student)o2;  
		  
		if(s1.getMarks()==s2.getMarks())  
		return 0;  
		else if(s1.getMarks()>s2.getMarks())  
		return -1;  
		else  
		return 1;  
		}   
}
