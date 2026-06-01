import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FeiraApiService } from '../../services/feira-api';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-lista-feiras',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './lista-feiras.html',
  styleUrl: './lista-feiras.css',
})
export class ListaFeirasComponent implements OnInit {
  feiras: any[] = [];
  carregando = false;

  constructor(private api: FeiraApiService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.carregarFeiras();
  }

  carregarFeiras() {
    this.carregando = true;
    this.api.getFeiras().subscribe(
      dados => {
        let arr: any[] = [];
        if (Array.isArray(dados)) {
          arr = dados;
        } else if (dados && Array.isArray((dados as any).content)) {
          arr = (dados as any).content;
        } else if (dados && Array.isArray((dados as any).data)) {
          arr = (dados as any).data;
        }

        this.feiras = arr.map(feira => ({ ...feira, tipoFeira: feira.tipoFeira ?? (feira.tipoFeiraNome ? {nome: feira.tipoFeiraNome} : undefined) }));

        this.carregando = false;
        this.cdr.detectChanges();
      },
      erro => {
        console.error('Erro ao carregar', erro);
        this.carregando = false;
        this.cdr.detectChanges();
      }
    );
  }

  deletarFeira(id: number) {
    this.api.deletarFeira(id).subscribe(
      () => this.carregarFeiras(),
      erro => console.error('Erro ao deletar', erro)
    );
  }
}
