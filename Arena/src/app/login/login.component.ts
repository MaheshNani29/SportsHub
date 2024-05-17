import { Component, OnInit } from '@angular/core';
// import { NgForm } from '@angular/forms';
import { UserdetailsService } from '../service/userdetails.service';
import { Router } from '@angular/router';
import { Userdetails } from '../models/userdetails';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  userdetails: Userdetails = new Userdetails();

  
  constructor(private userService: UserdetailsService, private router: Router) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  
  onSubmit(): void { 
    this.userService.logIn(this.userdetails.mailId, this.userdetails.password).subscribe(data=>{
       
      this.userdetails=data;
        if (this.userdetails.mailId ==='admin@gmail.com' && this.userdetails.password==='admin123'){
          localStorage.setItem('user','admin');
          localStorage.setItem('id',""+this.userdetails.userId);
          this.router.navigate(['/admin']);
        }
        else{
          localStorage.setItem('id',""+this.userdetails.userId);
          localStorage.setItem('user','user');
          this.router.navigate(['/home']); 
        }
      },error => {
        alert('Check your credentials once. If you are not registered, please register.');
      });
        
      }
      
     
  }
 