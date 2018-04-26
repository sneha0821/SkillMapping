import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddemployeeComponent} from './addemployee/addemployee.component';
import {DisplayemployeeComponent} from'./displayemployee/displayemployee.component';
import { RouterModule, Routes } from '@angular/router';
import {HomecomponentComponent} from './homecomponent/homecomponent.component';
import {EditemployeeComponent} from './editemployee/editemployee.component';

const routes: Routes = [
   { path: '', redirectTo: 'homeComponent', pathMatch: 'full' },
  { path: 'addEmployee', component: AddemployeeComponent },
  { path: 'displayDetail', component: DisplayemployeeComponent },
  { path :'edit/:empId', component:EditemployeeComponent}
]
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
