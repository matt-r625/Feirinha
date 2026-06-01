import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { FeiraApiService } from '../../services/feira-api';

@Component({
  selector: 'app-form-feira',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './form-feira.html',
  styleUrl: './form-feira.css',
})
export class FormFeiraComponent implements OnInit {
  nome = '';
  descricao = '';
  tipoFeiraId = 0;
  tipoFeira: any[] = [];
  mensagem = '';

  constructor(private api: FeiraApiService, private router: Router, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.carregarTiposFeira();
  }

  carregarTiposFeira() {
    this.api.getTipoFeira().subscribe(
      dados => {this.tipoFeira = dados; this.cdr.detectChanges();},
      erro => console.error('Erro ao carregar tipos de feira', erro)
    );
  }

  salvarFeira() {
    const novaFeira = {
      nome: this.nome,
      descricao: this.descricao,
      tipoFeiraId: this.tipoFeiraId
    };

    this.api.criarFeira(novaFeira).subscribe(
      () => {
        this.router.navigate(['/feiras']);
      },
      erro => {
        this.mensagem = 'Erro ao criar feira: ' + erro.message;
        this.cdr.detectChanges();
      }
    );
  }
}
