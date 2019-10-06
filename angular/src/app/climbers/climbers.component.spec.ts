import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimbersComponent } from './climbers.component';

describe('ClimbersComponent', () => {
  let component: ClimbersComponent;
  let fixture: ComponentFixture<ClimbersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimbersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimbersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
