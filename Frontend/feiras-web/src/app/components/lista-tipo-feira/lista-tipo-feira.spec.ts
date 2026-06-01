import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaTipoFeira } from './lista-tipo-feira';

describe('ListaTipoFeira', () => {
  let component: ListaTipoFeira;
  let fixture: ComponentFixture<ListaTipoFeira>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaTipoFeira],
    }).compileComponents();

    fixture = TestBed.createComponent(ListaTipoFeira);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
