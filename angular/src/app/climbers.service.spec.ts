import { TestBed } from '@angular/core/testing';

import { ClimbersService } from './climbers.service';

describe('ClimbersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClimbersService = TestBed.get(ClimbersService);
    expect(service).toBeTruthy();
  });
});
