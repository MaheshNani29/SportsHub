import { Component } from '@angular/core';
import { MyBookings } from '../models/my-bookings';
import { BookService } from '../service/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-booking-list',
  templateUrl: './admin-booking-list.component.html',
  styleUrl: './admin-booking-list.component.css'
})
export class AdminBookingListComponent {

  
  myBookings: MyBookings[] =[];

 
  constructor(private bookService:BookService,private router:Router) {}
 
  ngOnInit(): void {
      this.bookService.getAllBookings().subscribe((data:MyBookings[]) => {
        this.myBookings = data;
        // console.log(this.myBookings);
      });
  }

}
