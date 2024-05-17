import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SportsComponent } from './sports/sports.component';
import { AdminComponent } from './admin/admin.component';
import { AddSportComponent } from './add-sport/add-sport.component';
import { BookingComponent } from './booking/booking.component';
import { MyBookingsComponent } from './my-bookings/my-bookings.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { AdminBookingComponent } from './admin-booking/admin-booking.component';
import { AdminBookingListComponent } from './admin-booking-list/admin-booking-list.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UpdateSportComponent } from './update-sport/update-sport.component';
import { userauthGuard } from './userauth.guard';
import { adminauthGuard } from './adminauth.guard';
import { FirstpageComponent } from './firstpage/firstpage.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [

  {path:'', component :FirstpageComponent},

  {path:'registration', component :RegistrationComponent},

  {path:'login', component :LoginComponent},




  {path:'home',canActivate:[userauthGuard],component :HomeComponent},

  {path:'sport',canActivate:[userauthGuard], component :SportsComponent},

  {path:'booking',canActivate:[userauthGuard], component :BookingComponent},

  {path:'myBookings',canActivate:[userauthGuard], component :MyBookingsComponent},




  {path:'addsport',canActivate:[adminauthGuard], component :AddSportComponent},

  {path:'updateSport/:id', canActivate:[adminauthGuard], component :UpdateSportComponent},

  {path:'admin',canActivate:[adminauthGuard], component :AdminComponent},

  {path:'adminBooking',canActivate:[adminauthGuard], component :AdminBookingComponent},

  {path:'adminBookingList',canActivate:[adminauthGuard], component :AdminBookingListComponent},

  {path:'users',canActivate:[adminauthGuard], component :UsersComponent},




  {path:'**',component:NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
