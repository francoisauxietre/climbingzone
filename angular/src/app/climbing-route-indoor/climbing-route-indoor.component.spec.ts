import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingRouteIndoorComponent } from './climbing-route-indoor.component';

describe('ClimbingRouteIndoorComponent', () => {
  let component: ClimbingRouteIndoorComponent;
  let fixture: ComponentFixture<ClimbingRouteIndoorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingRouteIndoorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingRouteIndoorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
