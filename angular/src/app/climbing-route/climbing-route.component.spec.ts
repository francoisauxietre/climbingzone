import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingRouteComponent } from './climbing-route.component';

describe('ClimbingRouteComponent', () => {
  let component: ClimbingRouteComponent;
  let fixture: ComponentFixture<ClimbingRouteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingRouteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
