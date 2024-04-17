import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { AuthService } from './services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  router: Router;
  authService: AuthService;

  constructor(
    router: Router,
    authService: AuthService
  ) {
    this.router = router;
    this.authService = authService;
  }

  login() {
    this.router.navigate(['/login']);
  }

  signUp() {
    this.router.navigate(['/sign-up']);
  }

  logout() {
    this.authService.logout();
  }
}
