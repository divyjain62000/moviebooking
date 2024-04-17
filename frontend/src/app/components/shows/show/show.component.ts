import { Component, Input } from '@angular/core';
import { ShowData } from '../../../interfaces/showData';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../services/auth.service';
import { BookingConfirmationComponent } from '../booking-confirmation/booking-confirmation.component';
import { ShowService } from '../../../services/show.service';
import { Router } from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-show',
  standalone: true,
  imports: [CommonModule, BookingConfirmationComponent],
  templateUrl: './show.component.html',
  styleUrl: './show.component.css'
})
export class ShowComponent {
  authService: AuthService;
  showService: ShowService;
  router: Router;

  @Input() show: ShowData | undefined;

  constructor(
    authService: AuthService,
    showService: ShowService,
    router: Router
  ) {
    this.authService = authService;
    this.showService = showService;
    this.router = router;
  }

  openBookingConfirmationModal() {
    if (this.show) {
      $(`#bookingConfirmation${this.show.id}`).modal('show');
    }
  }

  editShow(showId: number) {
    this.router.navigate(['shows/edit-show', showId]);
  }

  deleteShow(showId: number) {
    this.showService.removeShow(showId).subscribe((_) => {
      window.location.reload();
    });
  }
}
