import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ShowData } from '../interfaces/showData';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ShowService {
  http: HttpClient;
  router: Router;

  url = 'http://127.0.0.1:8080';

  constructor(http: HttpClient, router: Router) {
    this.http = http;
    this.router = router;
  }

  getShows() {
    return this.http.get<ShowData[]>(`${this.url}/movie-shows`);
  }

  getShow(showId: number) {
    return this.http.get<ShowData>(`${this.url}/movie-shows/${showId}`);
  }

  createShow(showData: ShowData) {
    this.http.post<ShowData>(`${this.url}/movie-shows`, showData).subscribe((_) => {
      this.router.navigate(['/']);
    });
  }

  editShow(showId: number, showData: ShowData) {
    return this.http.put<ShowData>(`${this.url}/movie-shows/${showId}`, showData);
  }

  removeShow(showId: number) {
    return this.http.delete(`${this.url}/movie-shows/${showId}`);
  }
}
