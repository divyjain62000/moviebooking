import { Component, OnInit } from '@angular/core';
import { ShowService } from '../../services/show.service';
import { ShowData } from '../../interfaces/showData';
import { ShowComponent } from './show/show.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-shows',
  standalone: true,
  templateUrl: './shows.component.html',
  styleUrl: './shows.component.css',
  imports: [ShowComponent, CommonModule]
})
export class ShowsComponent implements OnInit {
  showService: ShowService;
  shows: ShowData[] = [];

  constructor(showService: ShowService) {
    this.showService = showService;
  }

  ngOnInit() {
    this.showService.getShows().subscribe((showList) => {
      this.shows = showList;
    });
  }
}
