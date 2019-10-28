import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbersDetailComponent } from './climbers-detail.component';

describe('ClimbersDetailComponent', () => {
  let component: ClimbersDetailComponent;
  let fixture: ComponentFixture<ClimbersDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbersDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbersDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
