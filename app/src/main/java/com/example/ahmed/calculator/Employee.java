package com.example.ahmed.calculator;

/**
 * Created by Ahmed on 5/16/2015.
 */
public class Employee
{

    private String Name;
    private String Job;

    public Employee(String n,String j)
    {
        this.Name=n;
        this.Job=j;
    }

    public void setJob(String job)
    {
        Job = job;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getJob()
    {
        return Job;
    }

    public String getName()
    {
        return Name;
    }
}
