import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingrouteComponent } from './climbingroute.component';

describe('ClimbingrouteComponent', () => {
  let component: ClimbingrouteComponent;
  let fixture: ComponentFixture<ClimbingrouteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingrouteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingrouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
