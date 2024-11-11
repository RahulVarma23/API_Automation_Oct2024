package model;

public class Employee {

     String name;
     String job;
     int age;


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public Employee(String name, String job, int age) {
        this.name=name;
        this.job=job;
        this.age=age;
    }

    public Employee(String name, String job) {
        this.name=name;
        this.job=job;
    }

    public Employee(String name) {
        this.name=name;
    }


}
