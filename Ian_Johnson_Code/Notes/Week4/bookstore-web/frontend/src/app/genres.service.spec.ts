import { TestBed, inject } from '@angular/core/testing';

import { GenresService } from './genres.service';

describe('GenresService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GenresService]
    });
  });

  it('should be created', inject([GenresService], (service: GenresService) => {
    expect(service).toBeTruthy();
  }));
});
