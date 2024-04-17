import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ShowData } from '../../../interfaces/showData';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ShowService } from '../../../services/show.service';

@Component({
  selector: 'app-edit-show',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './edit-show.component.html',
  styleUrl: './edit-show.component.css'
})
export class EditShowComponent implements OnInit {
  showService: ShowService;
  route: ActivatedRoute;
  router: Router;

  showId: number = 0;

  showForm: ShowData = {
    movieName: '',
    showTimming: '',
    theaterAddress: '',
    totalSeats: 0,
    availableSeats: 0,
    ticketPrice: 0,
    posterURL: ''
  }

  currentDateTime: string = new Date().toISOString().substring(0, 16);

  constructor(
    route: ActivatedRoute,
    showService: ShowService,
    router: Router
  ) {
    this.route = route;
    this.showService = showService;
    this.router = router;
  }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.showId = params['id'];

      this.showService.getShow(this.showId).subscribe((showData) => {
        this.showForm = showData;
      })
    });
  }

  onSubmit() {
    this.showService.editShow(this.showId, this.showForm).subscribe((res) => {
      this.router.navigate(['/']);
    });
  }
}
