import { TestBed, inject } from '@angular/core/testing';

import { DictionaryService } from './dictionary.service';

describe('DictionaryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DictionaryService]
    });
  });

  it('should be created', inject([DictionaryService], (service: DictionaryService) => {
    expect(service).toBeTruthy();
  }));
});
