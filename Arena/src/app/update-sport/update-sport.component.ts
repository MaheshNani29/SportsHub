import { Component } from '@angular/core';
import { Sports } from '../models/sports';
import { SportsService } from '../service/sports.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-sport',
  templateUrl: './update-sport.component.html',
  styleUrl: './update-sport.component.css'
})
export class UpdateSportComponent {

  sports: Sports= new Sports();
 
  sportId!:number;
 
  constructor(private sportsService:SportsService,private route:ActivatedRoute,private router:Router){}
 
 
 
  ngOnInit(): void {
    this.sportId=this.route.snapshot.params['id'];
    this.sportsService.getSportById(this.sportId).subscribe(data => {
      this.sports = data;
    })
  }
 
  updateSport(){
    this.sportsService.updateSportsBasedOnSportId(this.sportId, this.sports).subscribe(data => {
      this.sports = data;
      console.log(data);
      this.router.navigate(['admin']);
    });
  }
 
 
 
 
}