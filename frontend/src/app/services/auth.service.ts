import { Injectable } from '@angular/core';
import { LoginData } from '../interfaces/loginData';
import { RegistrationData } from '../interfaces/registrationData';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  http: HttpClient;

  router: Router;

  url = 'http://127.0.0.1:8080';

  constructor(
    http: HttpClient,
    router: Router
  ) {
    this.http = http;
    this.router = router;
  }

  isAuthenticated() {
    const user = localStorage.getItem('user');

    return !!user;
  }

  isAdmin() {
    const user = localStorage.getItem('user');

    if (user) {
      return JSON.parse(user).admin;
    }

    return false;
  }

  getUserId(): number {
    const user = localStorage.getItem('user');

    if (user) {
      return JSON.parse(user).id;
    }

    return -1;
  }

  getUser() {
    const user = localStorage.getItem('user');

    if (user) {
      return JSON.parse(user);
    }

    return null;
  }

  login(loginData: LoginData) {
    this.http.post<RegistrationData>(`${this.url}/login`, loginData).subscribe(
      (loginResponse) => {
        if (loginResponse.id) {
          localStorage.setItem('user', JSON.stringify(loginResponse));

          this.router.navigate(['/']);
        }
      },
      (loginError) => {
        window.alert('Invalid Credentials');
      }
    );
  }

  signUp(signUpData: RegistrationData) {
    this.http.post<RegistrationData>(`${this.url}/users`, signUpData).subscribe((signUpResponse) => {
      if (signUpResponse.id) {
        localStorage.setItem('user', JSON.stringify(signUpResponse));

        this.router.navigate(['/']);
      }
    });
  }

  logout() {
    localStorage.removeItem('user');

    this.router.navigate(['/login']);
  }
}
