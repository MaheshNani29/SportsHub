import { Component } from '@angular/core';
import { Userdetails } from '../models/userdetails';
import { UserdetailsService } from '../service/userdetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  userdetails: Userdetails=new Userdetails();

errorMessage: string ='';

constructor(private service: UserdetailsService, private router:Router){}

registerUser():void{
  this.service.addUser(this.userdetails).subscribe(
    response=> {
      console.log('User registered successfully:', response);
      alert("Thanks for registering");
      this.router.navigate(['login']);
    },
   
    (error)=>{
      console.log('Error registering user',error);
      this.errorMessage = 'Registration failed. Please try again.';
      this.router.navigate(['registration']);

    }
   
  );
  console.log(this.userdetails)
}

}