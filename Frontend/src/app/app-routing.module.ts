import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdmindashComponent} from "./admindash/admindash.component";
import {AppointmentComponent} from "./appointment/appointment.component";
import {CreateAppointmentComponent} from "./appointment/create-appointment/create-appointment.component";
import {HomeComponent} from "./home/home.component";
import {DocdashComponent} from "./docdash/docdash.component";
import {CreatePatientComponent} from "./patient/create-patient/create-patient.component";
import {MedicineListComponent} from "./medicine-list/medicine-list.component";
import {CreateMedicineComponent} from "./medicine-list/create-medicine/create-medicine.component";
import {UpdatePatientComponent} from "./patient/update-patient/update-patient.component";
import {ViewPatientComponent} from "./patient/view-patient/view-patient.component";
import {UpdateMedicineComponent} from "./medicine-list/update-medicine/update-medicine.component";
import {DocloginComponent} from "./doclogin/doclogin.component";
import {AdloginComponent} from "./adlogin/adlogin.component";
import {AdminauthguardService} from "./adminauthguard.service";
import {DocauthguardService} from "./docauthguard.service";

const routes: Routes = [
  {path:'admin',component:AdmindashComponent, canActivate:[AdminauthguardService]},
  {path:'appointmentlist', component:AppointmentComponent,canActivate:[AdminauthguardService]},
  {path:'create-appointment', component:CreateAppointmentComponent,canActivate:[AdminauthguardService]},
  {path:'home', component:HomeComponent},
  {path:'', redirectTo:'home', pathMatch:"full"},
  {path:'docdash', component:DocdashComponent, canActivate:[DocauthguardService]},
  {path:'create-patient', component:CreatePatientComponent, canActivate:[DocauthguardService]},
  {path:'view-medicines', component:MedicineListComponent, canActivate:[DocauthguardService]},
  {path:'create-medicine', component:CreateMedicineComponent, canActivate:[DocauthguardService]},
  {path:'update-patient/:id', component:UpdatePatientComponent, canActivate:[DocauthguardService]},
  {path:'view-patient/:id', component:ViewPatientComponent, canActivate:[DocauthguardService]},
  {path:'update-medicine/:id', component:UpdateMedicineComponent, canActivate:[DocauthguardService]},
  {path:'doclogin', component:DocloginComponent},
  {path:'adlogin', component:AdloginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
