import { TestBed } from '@angular/core/testing';

import { FeiraApiService } from './feira-api';

describe('FeiraApiService', () => {
  let service: FeiraApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeiraApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
