import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../service/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrl: './booking.component.css'
})
export class BookingComponent implements OnInit {

  book:Book = new Book();
  uid: number;
 
  constructor(private bookService:BookService,private router:Router){}

  ngOnInit(): void {
    const id:string=localStorage.getItem('id');
    this.uid=parseInt(id);
    this.book.userId=this.uid;
  }
 
  
  booking(){
    this.bookService.booking(this.book).subscribe(data => {
      console.log(data);
      if(data==="the slot is already booked"){
        alert(data);
      }
      else{
        alert('Your Slot is Booked! Enjoyyyyy');
        this.router.navigate(['myBookings']);
      }
      
    })
  }

}
