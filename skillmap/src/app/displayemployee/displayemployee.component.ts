import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Employee} from '../employee';
import { FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-displayemployee',
  templateUrl: './displayemployee.component.html',
  styleUrls: ['./displayemployee.component.css']
})
export class DisplayemployeeComponent implements OnInit {
  employees : Employee[]; 
  employee:Employee;
  employeeIdToUpdate = null;
  employeeForm = new FormGroup({
    title: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required)	   
});

  constructor(private employeeService:EmployeeService) { }

  ngOnInit() {
    this.getAllEmployees();

  }
  getAllEmployees() :void  {
    this.employeeService.getAllEmployees()
  .subscribe(
            alldata => this.employees =alldata,
            error => console.log("Error :: " + error)
  ) 
  }
  delete(employee: Employee): void {
    this.employees = this.employees.filter(h => h !== employee);
    this.employeeService.deleteEmployee(employee).subscribe();
  }
  loadEmployeeToEdit(empId: number){
    this.employeeService.getEmployeeById(empId)
    .subscribe(employee=>{this.employeeIdToUpdate = employee.empId;
      this.employeeForm.setValue({empName:this.employee.empName,empEmail:this.employee.empEmail,empType:this.employee.empType})
    },
    //  databyid => this.employee = databyid,
    error => console.log("Error :: " + error));
    }
  
}
