import {Component, OnInit} from '@angular/core';
import {Patient} from "../patient";
import {PatientService} from "../patient.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent implements OnInit{
  id:number = 0;
  patient:Patient=new Patient();

  constructor(private patientService:PatientService,private router:Router, private route:ActivatedRoute) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe(data=>{
      this.patient=data;
    });
  }

  saveAppointment(){
    this.patientService.updatePatientById(this.id,this.patient).subscribe(data=>{
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
