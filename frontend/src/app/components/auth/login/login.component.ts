import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { CommonModule } from '@angular/common';
import { LoginData } from '../../../interfaces/loginData';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  authService: AuthService;

  loginForm: LoginData = {
    email: '',
    password: ''
  };
  expression: any;

  constructor(authService: AuthService) {
    this.authService = authService;
  }

  onSubmit() {
    this.authService.login(this.loginForm);
  }
}
