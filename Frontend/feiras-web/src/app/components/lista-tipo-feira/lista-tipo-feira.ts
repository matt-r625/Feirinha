import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FeiraApiService } from '../../services/feira-api';

@Component({
  selector: 'app-lista-tipo-feira',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './lista-tipo-feira.html',
  styleUrl: './lista-tipo-feira.css',
})
export class ListaTipoFeiraComponent implements OnInit {
  tipoFeira: any[] = [];
  novoNome = '';
  novaDescricao = '';
  mensagem = '';
  carregando = false;

  constructor(private api: FeiraApiService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.carregarTiposFeira();
  }

  carregarTiposFeira() {
    this.carregando = true;
    this.api.getTipoFeira().subscribe(
      dados => {
        this.tipoFeira = Array.isArray(dados) ? dados : [];
        this.carregando = false;
        this.cdr.detectChanges();
      },
    );
  }

  cadastrarTipoFeira() {
    if(!this.novoNome.trim()) {
      this.mensagem = 'O nome do tipo de feira é obrigatório.';
      return;
    }
    this.api.criarTipoFeira({ nome: this.novoNome, descricao: this.novaDescricao }).subscribe(
      () => {
        this.mensagem = 'Tipo de feira cadastrado com sucesso!';
        this.novoNome = '';
        this.novaDescricao = '';
        this.cdr.detectChanges();  // atualiza mensagem e input antes de recarregar
        this.carregarTiposFeira();
      },
      erro => {
        this.mensagem = 'Erro ao cadastrar: ' + erro.message;
        this.cdr.detectChanges();
      }
    );
  }
}
