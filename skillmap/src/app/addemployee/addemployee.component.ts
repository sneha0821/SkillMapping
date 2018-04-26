import { Component, OnInit } from '@angular/core';
import { Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {
// employee:Employee[];
employees :Employee[];
  constructor(private employeeService:EmployeeService) { }

  ngOnInit() {
  }
//   onClickSubmit(data) 
//   {//this.employees = data.employee
// console.log(data);
//   }
// getAllEmployees()
// {
//   this.employeeService.getEmployees()
//   .subscribe(
//     data=>this.employees=data,
//     error=>console.log("Error::"+error))
//     // employees=>this.employees=employees);
// }
  add(empId:number,empName:string,empEmail:string,password:string,empType:string,qualification:string): void {
   console.log(empId);
   empId=empId;
    empName=empName.trim();
    empEmail=empEmail.trim();
    password=password.trim();
    empType=empType.trim();
    qualification=qualification.trim();
   // if (!name) { return; }
    this.employeeService.addEmployee({empId,empName,empEmail,password,empType,qualification} as Employee)
      .subscribe(employee => {
        this.employees.push(employee);
      });
      
  }
}
