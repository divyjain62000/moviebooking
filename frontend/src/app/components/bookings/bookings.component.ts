import { Component, OnInit } from '@angular/core';
import { BookingService } from '../../services/booking.service';
import { Booking } from '../../interfaces/bookingData';
import { CommonModule } from '@angular/common';
import { BookingComponent } from './booking/booking.component';

@Component({
  selector: 'app-bookings',
  standalone: true,
  imports: [CommonModule, BookingComponent],
  templateUrl: './bookings.component.html',
  styleUrl: './bookings.component.css'
})
export class BookingsComponent implements OnInit {
  bookingService: BookingService;

  bookings: Booking[] = [];

  constructor(bookingService: BookingService) {
    this.bookingService = bookingService;
  }

  ngOnInit(): void {
    this.bookingService.getBookings().subscribe((bookingList) => {
      this.bookings = bookingList;
    });
  }
}
