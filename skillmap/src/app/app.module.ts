import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import {EmployeeService} from './employee.service'
import { HttpModule } from '@angular/http';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DisplayemployeeComponent } from './displayemployee/displayemployee.component';
import { AppRoutingModule } from './/app-routing.module';
import { HomecomponentComponent } from './homecomponent/homecomponent.component';
import { EditemployeeComponent } from './editemployee/editemployee.component';
@NgModule({
  declarations: [
    AppComponent,
    AddemployeeComponent,
    DisplayemployeeComponent,
    HomecomponentComponent,
    EditemployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
