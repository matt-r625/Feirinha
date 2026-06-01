import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FeiraApiService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getFeiras(): Observable<any> {
    return this.http.get(`${this.apiUrl}/feiras`);
  }

  criarFeira(feira: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/feiras`, feira);
  }

  deletarFeira(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/feiras/${id}`);
  }

  getTipoFeira(): Observable<any> {
    return this.http.get(`${this.apiUrl}/tipo-feira`);
  }

  criarTipoFeira(tipoFeira: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/tipo-feira`, tipoFeira);
  }
}
