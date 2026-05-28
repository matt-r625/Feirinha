import { TestBed } from '@angular/core/testing';

import { FeiraApi } from './feira-api';

describe('FeiraApi', () => {
  let service: FeiraApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeiraApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
