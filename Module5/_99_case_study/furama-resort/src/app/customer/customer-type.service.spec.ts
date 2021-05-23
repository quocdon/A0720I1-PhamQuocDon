import { TestBed } from '@angular/core/testing';

import { CustomerTypeService } from './customer-type.service';

describe('CustomerTypeService', () => {
  let service: CustomerTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
