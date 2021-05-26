import { TestBed } from '@angular/core/testing';

import { AttachServiceService } from './attach-service.service';

describe('AttachServiceService', () => {
  let service: AttachServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AttachServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
