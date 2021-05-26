import { TestBed } from '@angular/core/testing';

import { ResortServiceService } from './resort-service.service';

describe('ResortServiceService', () => {
  let service: ResortServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResortServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
