import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { RegistrationData } from '../../../interfaces/registrationData';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {
  authService: AuthService;

  registrationForm: RegistrationData = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    confirmPassword: '',
    mobileNumber: ''
  }
  isPasswordValid: boolean = false;

  constructor(authService: AuthService) {
    this.authService = authService;
  }

  onSubmit() {
    if (this.isValid()) {
      this.authService.signUp(this.registrationForm);
    }
  }

  isValid() {
    if (this.registrationForm.password === this.registrationForm.confirmPassword) {
      this.isPasswordValid = true;
    }

    return this.isPasswordValid;
  }
}
