import { Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { authGuard } from './gaurds/auth.guard';
import { RegistrationComponent } from './components/auth/registration/registration.component';
import { CreateShowComponent } from './components/admin/create-show/create-show.component';
import { ShowsComponent } from './components/shows/shows.component';
import { BookingsComponent } from './components/bookings/bookings.component';
import { EditShowComponent } from './components/admin/edit-show/edit-show.component';

export const routes: Routes = [
    { path: '', component: ShowsComponent, canActivate: [authGuard] },
    { path: 'login', component: LoginComponent, canActivate: [authGuard] },
    { path: 'sign-up', component: RegistrationComponent, canActivate: [authGuard] },
    {
        path: 'shows',
        children: [
            { path: 'create-show', component: CreateShowComponent, canActivate: [authGuard] },
            { path: 'edit-show/:id', component: EditShowComponent, canActivate: [authGuard] },
        ]
    },
    { path: 'bookings', component: BookingsComponent, canActivate: [authGuard] }
];