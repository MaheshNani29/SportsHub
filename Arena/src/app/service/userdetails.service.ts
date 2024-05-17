import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Userdetails } from '../models/userdetails';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserdetailsService {

  addUserUrl="http://localhost:8080/api/users/adduser";

  baseLoginURL = "http://localhost:8080/api/users";

  getUsersUrl = "http://localhost:8080/api/users/allUsers";

  constructor(private http:HttpClient) { }


  addUser(userdetails:Userdetails):Observable<Userdetails>{
    return this.http.post<Userdetails>(`${this.addUserUrl}`,userdetails);
  }

  logIn(mailId:string,password:string):Observable<Userdetails>{
    return this.http.get<Userdetails>(`${this.baseLoginURL}/${mailId}/${password}`);
  }

  getUserById(id:number):Observable<Userdetails> {
    return this.http.get<Userdetails>(`${this.baseLoginURL}/${id}`);

  }

  getAllUsers():Observable<Userdetails[]>{
    return this.http.get<Userdetails[]>(`${this.getUsersUrl}`);
  }
  
}
