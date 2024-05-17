import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SportsService } from '../service/sports.service';
import { Sports } from '../models/sports';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrl: './sports.component.css'
})
export class SportsComponent implements OnInit {

  sports: Sports[] = [];

  constructor(private sportService:SportsService , private router:Router){}

  ngOnInit():void{
     this.sportService.getAllSports().subscribe((data:Sports[])=> {
      console.log(data);
     this.sports = data;

  })

}
}

 