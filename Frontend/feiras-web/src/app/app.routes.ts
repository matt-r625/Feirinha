import { Routes } from '@angular/router';
import { ListaFeirasComponent } from './components/lista-feiras/lista-feiras';
import { FormFeiraComponent } from './components/form-feira/form-feira';
import { ListaTipoFeiraComponent } from './components/lista-tipo-feira/lista-tipo-feira';

export const routes: Routes = [
    {path: '', redirectTo: 'feiras', pathMatch: 'full'},
    {path: 'feiras', component: ListaFeirasComponent},
    {path: 'feiras/nova', component: FormFeiraComponent},
    {path: 'tipo-feira', component: ListaTipoFeiraComponent},
    {path: '**', redirectTo: 'feiras'}
];
