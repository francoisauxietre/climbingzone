import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbingRouteListComponent } from './climbing-route-list.component';

describe('ClimbingRouteListComponent', () => {
  let component: ClimbingRouteListComponent;
  let fixture: ComponentFixture<ClimbingRouteListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbingRouteListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbingRouteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
