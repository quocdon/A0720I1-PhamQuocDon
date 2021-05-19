import { TestBed, inject } from '@angular/core/testing';

import { DateUtilService } from './date-util.service';

describe('DateUtilService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DateUtilService]
    });
  });

  it('should be created', inject([DateUtilService], (service: DateUtilService) => {
    expect(service).toBeTruthy();
  }));
});
