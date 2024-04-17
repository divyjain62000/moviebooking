import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { BookingFormData } from '../../../interfaces/bookingData';
import { AuthService } from '../../../services/auth.service';
import { ShowData } from '../../../interfaces/showData';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PaymentData, PaymentFormData } from '../../../interfaces/payment';
import { BookingService } from '../../../services/booking.service';
import { Router } from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-booking-confirmation',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './booking-confirmation.component.html',
  styleUrl: './booking-confirmation.component.css'
})
export class BookingConfirmationComponent implements OnInit {
  authService: AuthService;
  bookingService: BookingService;

  router: Router;

  bookingForm: BookingFormData = {
    user: {
      id: 0
    },
    movieShow: {
      id: 0
    },
    totalBookedSeats: 0
  };

  paymentForm: PaymentFormData = {
    paymentMode: 'Debit Card',
    cardNumber: 0,
    month: 0,
    year: 0,
    cvv: 0
  };

  bookingId: number = 0;

  @Input() show: ShowData | undefined;

  @ViewChild('bookingConfirmation') bookingConfirmation: any;
  @ViewChild('paymentConfirmation') paymentConfirmation: any;

  constructor(
    authService: AuthService,
    bookingService: BookingService,
    router: Router
  ) {
    this.authService = authService;
    this.bookingService = bookingService;
    this.router = router;
  }

  ngOnInit(): void {
    this.bookingForm = {
      user: {
        id: this.authService.getUserId()
      },
      movieShow: {
        id: this.show?.id || 0
      },
      totalBookedSeats: 0
    };
  }

  onBooking() {
    this.bookingService.bookShow(this.bookingForm).subscribe(
      (res) => {
        if (this.show) {
          this.bookingId = res.id;

          $(`#bookingConfirmation${this.show.id}`).modal('hide');
          $(`#paymentConfirmation${this.show.id}`).modal('show');
        }
      },
      (err) => {
        console.log(err);
      }
    );
  }

  onPayment() {
    const paymentData: PaymentData = {
      paymentMode: this.paymentForm.paymentMode,
      status: 'COMPLETED',
      totalAmount: this.bookingForm.totalBookedSeats * (this.show?.ticketPrice || 1),
      booking: {
        id: this.bookingId
      }
    };

    this.bookingService.makePayment(paymentData).subscribe(
      (res) => {
        if (this.show) {
          $(`#paymentConfirmation${this.show.id}`).modal('hide');

          this.router.navigate(['/bookings']);
        }
      },
      (err) => {
        console.log(err);
      }
    );
  }

  cancelBooking() {
    this.bookingService.removeBooking(this.bookingId).subscribe((res) => {
      if (this.show) {
        $(`#paymentConfirmation${this.show.id}`).modal('hide');
      }
    });
  }
}
