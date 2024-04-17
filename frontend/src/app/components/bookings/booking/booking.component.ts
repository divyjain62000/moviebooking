import { Component, Input } from '@angular/core';
import { Booking } from '../../../interfaces/bookingData';
import { CommonModule } from '@angular/common';
import { BookingService } from '../../../services/booking.service';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './booking.component.html',
  styleUrl: './booking.component.css'
})
export class BookingComponent {
  bookingService: BookingService;

  @Input() bookingData: Booking | undefined;

  constructor(bookingService: BookingService) {
    this.bookingService = bookingService;
  }

  cancelBooking(bookingId: number) {
    this.bookingService.removeBooking(bookingId).subscribe((_) => {
      window.location.reload();
    });
  }
}
