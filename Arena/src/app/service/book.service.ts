import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../models/book';
import { Observable } from 'rxjs';
import { MyBookings } from '../models/my-bookings';
import { Sports } from '../models/sports';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  postBookUrl = "http://localhost:8080/api/slotBooking";

  getBookUrl = "http://localhost:8080/api/viewBookings";

  cancelBookUrl = "http://localhost:8080/api/delete";

  getBookingsByUserId = "http://localhost:8080/api/bookings";


  constructor(private http:HttpClient) { }

  booking(book:Book):Observable<Object>{
    return this.http.post<Book>(`${this.postBookUrl}`, book, {responseType: 'text' as 'json'});
  } 
  

  getAllBookings():Observable<MyBookings[]>{
    return this.http.get<MyBookings[]>(`${this.getBookUrl}`);
  }

  bookingsByUserId(id:number):Observable<MyBookings[]>{
    return this.http.get<MyBookings[]>(`${this.getBookingsByUserId}/${id}`);
  }

  cancelBooking(id:number):Observable<Object> {
    return this.http.delete<Book>(`${this.cancelBookUrl}/${id}`, {responseType: 'text' as 'json'});
  }



}
