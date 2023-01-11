package com.mile.main;

import com.mile.bean.Student;
import com.mile.exception.NullMarksArrayException;
import com.mile.exception.NullNameException;
import com.mile.exception.NullStudentException;
import com.mile.service.StudentReport;
import com.mile.service.StudentService;

public class StudentMain {
    static Student data[] = new Student[10];

    static {
        for (int i = 0; i < data.length; i++)
            data [i]= new Student();

        data [0] = new Student("Abhishek", new int[] {20, 25, 30});
        data [1] = new Student(null, new int[] {21, 42, 31});
        data [2] = null;
        data [3] = new Student("Ram", null);
        data [4] = new Student("Suman", new int[] {70, 82, 50});
        data [5] = new Student("Shyam", new int[] {31, 54, 90});
        data [6] = new Student("Alice", new int[] {65, 79, 88});
        data [7] = null; // TC4
        data [8] = new Student(null, new int[] {95, 75, 48});
        data [9] = new Student("Dinesh", null);

    }

    public static void main(String[] args) {
        StudentReport studentReport = new StudentReport();
        StudentService studentService = new StudentService();

        System.out.println("Grade Calculation:");

        String x = null;

        for (int i = 0; i < data.length; i++)  {
            try {
                x = studentReport.validate(data[i]);
            } catch (NullNameException e) {
                x = "NullNameException occurred";
            } catch (NullMarksArrayException e) {
                x = "NullMarksArrayException occurred";
            } catch (NullStudentException e) {
                x = "NullStudentException occurred";
            }

            System.out.println("GRADE = " + x);
        }

        System.out.println("Number of Objects with Marks array as null = " +
                studentService.findNumberOfNullMarks(data));
        System.out.println("Number of Objects with Name as null = " +
                studentService.findNumberOfNullNames(data));
        System.out.println("Number of Objects that are entirely null = " +
                studentService.findNumberOfNullObjects(data));

        System.out.println("TC7: Number of Objects with Name as null = " +
                studentService.findNumberOfNullNames(data));

        System.out.println("TC8: Number of Objects that are entirely null = " +
                studentService.findNumberOfNullObjects(data));

        System.out.println("TC9: Number of Objects with Marks array as null = " +
                studentService.findNumberOfNullMarks(data));
    }

}