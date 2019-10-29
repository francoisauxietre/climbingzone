import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingRouteOutdoorComponent } from './climbing-route-outdoor.component';

describe('ClimbingRouteOutdoorComponent', () => {
  let component: ClimbingRouteOutdoorComponent;
  let fixture: ComponentFixture<ClimbingRouteOutdoorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingRouteOutdoorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingRouteOutdoorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
