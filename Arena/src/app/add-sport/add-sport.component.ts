import { Component } from '@angular/core';
import { Sports } from '../models/sports';
import { SportsService } from '../service/sports.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-sport',
  templateUrl: './add-sport.component.html',
  styleUrl: './add-sport.component.css'
})
export class AddSportComponent {
 
  sport:Sports = new Sports();
 
  constructor(private sportsService:SportsService,private router:Router){}
 
  addSport(){
    this.sportsService.addSport(this.sport).subscribe(data => {
      console.log(data);
      alert('New Sport added Successfully');
      this.router.navigate(['admin']);
    })
  }
 
}