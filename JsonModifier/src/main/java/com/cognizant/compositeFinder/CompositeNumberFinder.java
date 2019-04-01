package com.cognizant.compositeFinder;

import java.util.Scanner;
public class CompositeNumberFinder {

	   int flag,n,i,j;
	   CompositeNumberFinder()
	     {
	       System.out.print("Enter range to find the composite numbers: ");
	       Scanner in=new Scanner(System.in);
	       n=in.nextInt();
	       for(i=2;i<=n;i++ )
	        {
	            flag=0;
	           for(j=2;j<i;j++)
	             {
	                 if(i % j == 0)
	                    flag++;
	             }
	           if(flag!=0)
	            System.out.println(i);
	        }
	    }
	public static void main(String args[])    
	      {
	           CompositeNumberFinder ob=new CompositeNumberFinder();
	      }
	}

