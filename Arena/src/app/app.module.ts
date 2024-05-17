import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { SportsComponent } from './sports/sports.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AddSportComponent } from './add-sport/add-sport.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BookingComponent } from './booking/booking.component';
import { MyBookingsComponent } from './my-bookings/my-bookings.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { AdminBookingComponent } from './admin-booking/admin-booking.component';
import { AdminBookingListComponent } from './admin-booking-list/admin-booking-list.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UpdateSportComponent } from './update-sport/update-sport.component';
import { FirstpageComponent } from './firstpage/firstpage.component';
import { UsersComponent } from './users/users.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AdminComponent,
    SportsComponent,
    AdminHeaderComponent,
    AddSportComponent,
    BookingComponent,
    UpdateSportComponent,
    MyBookingsComponent,
    RegistrationComponent,
    LoginComponent,
    AdminBookingComponent,
    AdminBookingListComponent,
    NotFoundComponent,
    FirstpageComponent,
    UsersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
