import { Component, OnInit,Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {EmployeeService} from '../employee.service';
import {Employee} from '../employee';

@Component({
  selector: 'app-editemployee',
  templateUrl: './editemployee.component.html',
  styleUrls: ['./editemployee.component.css']
})
export class EditemployeeComponent implements OnInit {
 employee: Employee;
  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private location: Location) { }

  ngOnInit() {

    this.getEmployeeedit();
  }
  getEmployeeedit(): void {
    const id = +this.route.snapshot.paramMap.get('empId');
console.log("Component"+id);
    this.employeeService.getEmployeeById(id)
         .subscribe(employee => this.employee = employee);
  }
  goBack(): void {
   this.location.back();
 }
  save(): void {
     this.employeeService.updateEmployee(this.employee)
       .subscribe(() => this.goBack());
  }

}
