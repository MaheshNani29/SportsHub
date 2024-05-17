import { Component, OnInit } from '@angular/core';
import { MyBookings } from '../models/my-bookings';
import { BookService } from '../service/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-bookings',
  templateUrl: './my-bookings.component.html',
  styleUrl: './my-bookings.component.css'
})
export class MyBookingsComponent implements OnInit{
 

  myBookings: MyBookings[] =[];

  uid=Number(localStorage.getItem('id'));
 
  constructor(private bookService:BookService,private router:Router) {}
 
  ngOnInit(): void {
      this.bookService.bookingsByUserId(this.uid).subscribe((data:MyBookings[]) => {
        this.myBookings = data;
      });
  }


  cancelBooking(id:number){
    this.bookService.cancelBooking(id).subscribe(data => {
      console.log(data);
      if(data==="Your slot has been Canceled"){
        alert(data);
        
      }
      this.router.navigate(['myBookings']);
    })
  }

  // updateBooking(id:number){
  //   this.router.navigate(['updateBooking',id]);
  // }
 
}