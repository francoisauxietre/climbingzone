import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingRouteAddComponent } from './climbing-route-add.component';

describe('ClimbingRouteAddComponent', () => {
  let component: ClimbingRouteAddComponent;
  let fixture: ComponentFixture<ClimbingRouteAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingRouteAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingRouteAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
