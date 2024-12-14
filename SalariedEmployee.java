/*
Program Name: PayrollSystemTest.java
Programmer's Name: Elena Jones
 */
package payrollsystemtest;

//SalariedEmployee.java
//SalariedEmployee concrete class extends abstract class Employee
    
    class SalariedEmployee extends Employee {
        private double weeklySalary;
        
        // four-argument constructor
        public SalariedEmployee(String first, String last, String ssn, double salary) {
            super(first, last, ssn); // pass to Employee constructor
            setWeeklySalary(salary); // validate and store salary
        } // end four-argument SalariedEmployee constructor
        
        // set salary
        public void setWeeklySalary( double salary) {
            if (salary >= 0.0)
            weeklySalary = salary;
            else
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } // end method setWeeklySalary
        
        // return salary 
        public double getWeeklySalary() {
            return weeklySalary;
        } // end method getWeeklySalary
        
        // calculate earnings, override abstract method earnngs in Employee
        @Override
        public double earnings() {     // contract relationship, have to supply implementation
            return getWeeklySalary();
        } // end method earnings
        // return String representation of SalariedEmployee object
        
        @Override
        public String toString() {
            return String.format("salaried employee: %s\n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
        } // end method toString
        
    } // end class Salaried Employee
    
    // HourlyEmployee class extends Employee
    class HourlyEmployee extends Employee {
        private double wage; // wage per hour
        private double hours; // hours worked for week
        
        // five-argument constructor
        public HourlyEmployee(String first, String last, String ssn, double hourlyWage, double hoursWorked) {
            super(first, last, ssn);
            setWage(hourlyWage); // validate hourly wage
            setHours(hoursWorked); // validate hours worked
        } // end five-argument HourlyEmployee constructor
        
        // set wage
        public void setWage(double hourlyWage) {
            if(hourlyWage >= 0.0)
            wage = hourlyWage;
            else
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        } // end method setWage
        
        // return wage                                                          
        public double getWage() {
            return wage;
        }
        
        // set hours worked
        public void setHours(double hoursWorked) {
            if ((hoursWorked >= 0.0) && (hoursWorked <=168.0))
            hours = hoursWorked;
            else
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        } // end method setHours
        
        // return hours worked
        public double getHours() {
            return hours;
        } // end method getHours
        
        // calculate earnings, override abstract method earnings in Employee
        @Override
        public double earnings() {
            if (getHours() <= 40) // no overtime
            return getWage() * getHours();
            else
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        } // end method earnings
        
        // return String representation of HourlyEmployee object
        @Override
        public String toString() {
            return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
        } // end method toString
    
    } // end class Hourly Employee
  class CommissionEmployee extends Employee {
      private double grossSales; // gross weekly sales
      private double commissionRate; // commission percentage
      
      // five-argument constructor
      public CommissionEmployee(String first, String last, String ssn, double sales, double rate) {
          super(first, last, ssn);
          setGrossSales(sales);
          setCommissionRate(rate);
      } // end five-argument CommissionEmployee constructor
      
      // set commission rate
      public void setCommissionRate(double rate) {
          if (rate > 0.0 && rate < 1.0)
          commissionRate = rate;
          else
          throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
      } // end method setCommissionRate
      
      // return commission rate
      public double getCommissionRate() {
          return commissionRate;
      } // end method getCommissionRate
      
      // set gross sales amount
      public void setGrossSales(double sales) {
          if (sales >= 0.0)
          grossSales = sales;
          else
          throw new IllegalArgumentException("Gross sales must be >= 0.0");
      } // end method setGrossSales
      
      // return gross sales amount
      public double getGrossSales() {
          return grossSales;
      } // end method getGrossSales
      
      // calculate earnings, override abstract method earnings in Employee
      @Override
      public double earnings() {
          return getCommissionRate() * getGrossSales();
      } // end method earnings
      
      // return String representation of CommissionEmployee object
      @Override
      public String toString() {
          return String.format("%s: %s\n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
      } // end method toString
      
  } // end class CommissionEmployee
  
  //BasePlusCommissionEmployee class extends CommissionEmployee
  class BasePlusCommissionEmployee extends CommissionEmployee {
      private double baseSalary; // base salary per week
      
      // six-argument constructor
      public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary) {
          super(first, last, ssn, sales, rate);
          setBaseSalary(salary); // validate and store base salary
      } // end six-argument BasePlusCommissionEmployee constructor
      
      // set base salry
      public void setBaseSalary(double salary) {
          if (salary >= 0.0)
          baseSalary = salary;
          else
          throw new IllegalArgumentException("Base salary must be >= 0.0" );
      } // end method setBaseSalary
      
      // return base salary
      public double getBaseSalary() {
          return baseSalary;
      } // end method getBaseSalary
      
      // calculate earnings, override method earnings in CommissionEmployee
      @Override
      public double earnings() {
          return getBaseSalary() + super.earnings();
      } // end method earnings
      
      // return String representation of BasePlusCommissionEmployee object
      @Override
      public String toString() {
          return String.format("%s %s; %s: %.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
      } // end method toString
   
  } // end class BasePlusCommissionEmployee
