import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Sports } from '../models/sports';
import { SportsService } from '../service/sports.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {

  sports: Sports[] = [];

  sport:Sports = new Sports();
  showForm=false;


  constructor(private sportService:SportsService , private router:Router){}

  ngOnInit():void{
     this.sportService.getAllSports().subscribe((data:Sports[])=> {
      this.sports = data;
    })
  }


  addSport(){
    this.router.navigate(['addsport']);
  }
  
  deleteSport(id:number){
    this.sportService.deleteBookBasedOnSportId(id).subscribe(data =>{
      alert("Sport Deleted Successfully");
    })
  }

  goToUpdate(id:number){
    this.router.navigate(['updateSport',id]);
  }
 

}
