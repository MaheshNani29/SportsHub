import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sports } from '../models/sports';

@Injectable({
  providedIn: 'root'
})
export class SportsService {
  
  getSportsUrl="http://localhost:8080/api/sports/allsports";

  addSportUrl = "http://localhost:8080/api/sports/addsport";

  sportsUrl="http://localhost:8080/api/sports";
  
  constructor(private http:HttpClient) { }

  
  getAllSports():Observable<Sports[]>{
    return this.http.get<Sports[]>(`${this.getSportsUrl}`);
  }

  getSportById(id:number):Observable<Sports> {
    return this.http.get<Sports>(`${this.sportsUrl}/${id}`);
 
  }
     
  addSport(sport:Sports):Observable<Sports>{
    return this.http.post<Sports>(`${this.addSportUrl}`,sport);
  }

  deleteBookBasedOnSportId(id:number):Observable<Object> {
    return this.http.delete<Sports>(`${this.sportsUrl}/${id}`);
  }

  updateSportsBasedOnSportId(id:number, sports:Sports):Observable<Sports> {
    return this.http.put<Sports>(`${this.sportsUrl}/${id}`,sports);
  }

}

