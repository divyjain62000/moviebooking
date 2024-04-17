import { Component } from '@angular/core';
import { ShowData } from '../../../interfaces/showData';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ShowService } from '../../../services/show.service';

@Component({
  selector: 'app-create-show',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './create-show.component.html',
  styleUrl: './create-show.component.css'
})
export class CreateShowComponent {
  showService: ShowService;

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

  constructor(showService: ShowService) {
    this.showService = showService;
  }

  onSubmit() {
    this.showService.createShow(this.showForm);
  }
}
