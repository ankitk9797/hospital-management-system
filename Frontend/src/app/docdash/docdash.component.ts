import {Component, OnInit} from '@angular/core';
import {Patient} from "../patient/patient";
import {PatientService} from "../patient/patient.service";
import {Router} from "@angular/router";
import {DocauthService} from "../doclogin/docauth.service";
import {UserStorageService} from "../storage/user-stoarge.service";

@Component({
  selector: 'app-docdash',
  templateUrl: './docdash.component.html',
  styleUrl: './docdash.component.css'
})
export class DocdashComponent implements OnInit{

  patients: Patient[]=[];

  constructor(private patientService: PatientService, private router:Router, private docAuthService:DocauthService) { }

  ngOnInit(): void {

    this.getPatients();
  }

  private getPatients(){
    this.patientService.getPatientList().subscribe(data => { this.patients = data;
    });

  }

  protected update(id:number){
    this.router.navigate(['update-patient',id]);
  }
  protected delete(id:number){
    this.patientService.deletePatient(id).subscribe(data=>{
      console.log(data);
      this.getPatients()
    });
  }
  protected view(id:number){
    this.router.navigate(['view-patient',id]);
  }

  logout(){
    UserStorageService.signOut();
    this.router.navigate(['home']);
  }

}
