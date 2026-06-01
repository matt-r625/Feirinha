import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFeira } from './form-feira';

describe('FormFeira', () => {
  let component: FormFeira;
  let fixture: ComponentFixture<FormFeira>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormFeira],
    }).compileComponents();

    fixture = TestBed.createComponent(FormFeira);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
