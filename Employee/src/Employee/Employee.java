/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

/**
 *
 * @author Chelly
 */
public class Employee {
    
    //attributes
    private String empName;
    private double hours;
    private double rate;
    
    //constructor
    public Employee()
    {
        empName = "none";
        hours = 0.0;
        rate = 0.0;
    }
    
    public Employee(String ename, double h, double r)
    {
        empName = ename;
        hours = h;
        rate = r;
    }
    
    //behaviors
    
    
    //class methods
    public String getName()
    {
        return empName;
    }
    public void setName(String ename)
    {
        empName = ename;
    }
    
    public double getHours()
    {
        return hours;
    }
    public void setHours(double hours)
    {
        this.hours = hours;
    }
    
    public double getRate()
    {
        return rate;
    }
    public void setRate(double rate)
    {
        this.rate = rate;
    }
    public double getPay() {
        return hours * rate;
    }
}
