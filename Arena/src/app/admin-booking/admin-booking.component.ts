import { Component } from '@angular/core';
import { BookService } from '../service/book.service';
import { Router } from '@angular/router';
import { Book } from '../models/book';

@Component({
  selector: 'app-admin-booking',
  templateUrl: './admin-booking.component.html',
  styleUrl: './admin-booking.component.css'
})
export class AdminBookingComponent {

  book:Book = new Book();
 
  constructor(private bookService:BookService,private router:Router){}
 
  booking(){
    this.bookService.booking(this.book).subscribe(data => {
      console.log(data);
      if(data==="the slot is already booked"){
        alert(data);
      }
      else{
        alert('Your Slot is Booked! Enjoyyyyy');
        this.router.navigate(['adminBookingList']);
      }
      
    })
  }

}
