import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking, BookingData, BookingFormData } from '../interfaces/bookingData';
import { PaymentData } from '../interfaces/payment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  http: HttpClient;
  authService: AuthService;

  url = 'http://127.0.0.1:8080';

  constructor(
    http: HttpClient,
    authService: AuthService
  ) {
    this.http = http;
    this.authService = authService;
  }

  getBookings() {
    if (this.authService.isAdmin()) {
      return this.http.get<Booking[]>(`${this.url}/bookings`);
    } else {
      const userId = this.authService.getUserId();

      return this.http.get<Booking[]>(`${this.url}/bookings-by-user-id?userId=${userId}`);
    }
  }

  bookShow(bookShowData: BookingFormData) {
    return this.http.post<BookingData>(`${this.url}/bookings`, bookShowData);
  }

  removeBooking(bookingId: number) {
    return this.http.delete(`${this.url}/bookings/${bookingId}`)
  }

  makePayment(paymentData: PaymentData) {
    return this.http.post<PaymentData>(`${this.url}/payments`, paymentData);
  }
}
