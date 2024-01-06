package base3;

import java.io.*;

/**
 * @author cc
 * @create 2023/12/24
 * @description
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
       Employee[] staff = new Employee[3];
       staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
       staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
       staff[2] = new Employee("Tony Test",40000,1990,3,15);

       for (Employee e:staff){

       }
    }

    public static void writeData(DataOutput out, Employee e){
    }
}


class Employee{
    private String name;
    private int sale;
    private int year;
    private int mouth;
    private int day;

    public Employee(String name, int sale, int year, int mouth, int day) {
        this.name = name;
        this.sale = sale;
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}