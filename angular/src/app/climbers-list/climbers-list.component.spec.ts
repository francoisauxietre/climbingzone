import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbersListComponent } from './climbers-list.component';

describe('ClimbersListComponent', () => {
  let component: ClimbersListComponent;
  let fixture: ComponentFixture<ClimbersListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbersListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
