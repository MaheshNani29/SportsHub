import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrl: './admin-header.component.css'
})
export class AdminHeaderComponent {

  title = 'MANAGE SPORTS';

  constructor(private router:Router) {}

  

  Logout(){
    localStorage.removeItem("user");
    localStorage.removeItem("id");
    this.router.navigate(['/login']);

  }
}
