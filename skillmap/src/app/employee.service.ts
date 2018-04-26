import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import {Employee} from './employee'
import { ReturnStatement } from '@angular/compiler';
 
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class EmployeeService {
  private Url = 'http://localhost:8079/SkillMapWeb/web/emp';
  constructor( private http: HttpClient) { }

   getAllEmployees (): Observable<Employee[]> {
     return this.http.get<Employee[]>(this.Url)
      .pipe(

        catchError(this.handleError('getEmployees', []))
       );
  }
 addEmployee (employee: Employee): Observable<Employee> {
   console.log("service"+employee.empId);
  return this.http.post<Employee>(this.Url, employee, httpOptions).pipe(
  
    catchError(this.handleError<Employee>('addEmployee'))
  );
}
deleteEmployee (employee: Employee | number): Observable<Employee> {
  const id = typeof employee === 'number' ? employee : employee.empId;
  const url = `${this.Url}/${id}`;

  return this.http.delete<Employee>(url, httpOptions).pipe(
 
    catchError(this.handleError<Employee>('deleteEmployee'))
  );
}
getEmployeeById(empId:number):Observable<Employee>{
  console.log(empId);
  const url = `${this.Url}/${empId}`;
  return this.http.get<Employee>(this.Url);
}
updateEmployee (employee: Employee): Observable<any> {
  return this.http.put(this.Url, employee, httpOptions).pipe(
 
    catchError(this.handleError<any>('updateEmployee'))
  );
}
private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}
}
