import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingRouteAroundComponent } from './climbing-route-around.component';

describe('ClimbingRouteAroundComponent', () => {
  let component: ClimbingRouteAroundComponent;
  let fixture: ComponentFixture<ClimbingRouteAroundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingRouteAroundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingRouteAroundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
