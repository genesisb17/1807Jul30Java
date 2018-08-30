import { TestBed, inject } from '@angular/core/testing';

import { EmployeetableService } from '../employeetable/employeetable.service';

describe('EmployeetableService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmployeetableService]
    });
  });

  it('should be created', inject([EmployeetableService], (service: EmployeetableService) => {
    expect(service).toBeTruthy();
  }));
});
