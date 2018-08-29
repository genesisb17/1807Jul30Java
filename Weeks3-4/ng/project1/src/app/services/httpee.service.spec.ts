import { TestBed, inject } from '@angular/core/testing';

import { HttpeeService } from './httpee.service';

describe('HttpeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpeeService]
    });
  });

  it('should be created', inject([HttpeeService], (service: HttpeeService) => {
    expect(service).toBeTruthy();
  }));
});
