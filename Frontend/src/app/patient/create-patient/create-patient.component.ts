import { Component } from '@angular/core';
import {Patient} from "../patient";
import {AppointmentService} from "../../appointment/appointment.service";
import {Router} from "@angular/router";
import {PatientService} from "../patient.service";

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrl: './create-patient.component.css'
})
export class CreatePatientComponent {
  patient:Patient=new Patient();

  constructor(private patientService:PatientService,private router:Router) {
  }

  saveAppointment(){
    this.patientService.createPatient(this.patient).subscribe(data=>{
      console.log(data);
      this.gotToAppointment();
    });
  }

  onSubmit(){
    this.saveAppointment();
  }

  gotToAppointment(){
    this.router.navigate(['/docdash']);
  }

}
