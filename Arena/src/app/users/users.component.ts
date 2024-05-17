import { Component } from '@angular/core';
import { Userdetails } from '../models/userdetails';
import { Router } from '@angular/router';
import { UserdetailsService } from '../service/userdetails.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {

  userdetails: Userdetails[] =[];

 
  constructor(private userdetailsService:UserdetailsService,private router:Router) {}
 
  ngOnInit(): void {
      this.userdetailsService.getAllUsers().subscribe((data:Userdetails[]) => {
        this.userdetails = data;
        console.log(this.userdetails);
      });
  }

  
}
