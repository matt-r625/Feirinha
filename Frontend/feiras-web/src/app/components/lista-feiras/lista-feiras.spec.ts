import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaFeiras } from './lista-feiras';

describe('ListaFeiras', () => {
  let component: ListaFeiras;
  let fixture: ComponentFixture<ListaFeiras>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaFeiras],
    }).compileComponents();

    fixture = TestBed.createComponent(ListaFeiras);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
