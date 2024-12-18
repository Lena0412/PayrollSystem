/*
Program Name: PayrollSystemTest.java
Programmer's Name: Elena Jones
 */
package payrollsystemtest;

    abstract class Employee {
      private String firstName;
      private String lastName;
      private String socialSecurityNumber;
      
      // three-argument constructor
      public Employee(String first, String last, String ssn) {
          firstName = first;
          lastName = last;
          socialSecurityNumber = ssn;
      } // end three-argument Employee constructor
      
      // set first name
      public void setFirstName(String first) {
          firstName = first; // should validate
      } // end method setFirstName
      
      //return first name
      public String getFirstName() {
          return firstName;
      } // end method getFirstName
      
      //set last name
      public void setLastName(String last) {
          lastName = last; // should validate
      } // end method setLastName
      
      // return last name
      public String getLastName() {
          return lastName;
      } // end method getLastName
      
      // set social security number
      public void setSocialSecurityNumber(String ssn) {
          socialSecurityNumber = ssn; // should validate only, cannot reset value
      } // end method setSocialSecurityNumber
      
      // return social security number
      public String getSocialSecurityNumber() {
          return socialSecurityNumber;
      } // end method getSocialSecurityNumber
      
      //return String representation of Employee object
      @Override
      public String toString() {
          return String.format( "%s %s\nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
      } // end method toString
      
      // abstract method overridden be concrete subclasses
      public abstract double earnings();
      // no implementation here
    } // end abstract class Employee
    
      
  // PayrollSystemTest.java
  // Employee hierarchy test program
  public class PayrollSystemTest {
      public static void main(String[] args) {
          //create subclass objects
          SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
          HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
          CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
          BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04,300.00);
          System.out.println("Employees processed individually:\n");
          
          System.out.printf("%s\n%s: $%,.2f\n\n", salariedEmployee, "earned", salariedEmployee.earnings());
          System.out.printf("%s\n%s: $%,.2f\n\n", hourlyEmployee, "earned", hourlyEmployee.earnings());
          System.out.printf("%s\n%s: $%,.2f\n\n", commissionEmployee, "earned", commissionEmployee.earnings());
          System.out.printf("%s\n%s: $%,.2f\n\n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
          
          System.out.println("***************************************************************************************");
          
          // the following practices the downcast
          // create four-element Employee array
          Employee[] employees = new Employee[4];
          // initialize array with Employees
          employees[0] = salariedEmployee;
          employees[1] = hourlyEmployee;
          employees[2] = commissionEmployee;
          employees[3] = basePlusCommissionEmployee;
         
      } // end main
  } // end class PayrollSystemTest



