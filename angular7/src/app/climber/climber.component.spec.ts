import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimberComponent } from './climber.component';

describe('ClimberComponent', () => {
  let component: ClimberComponent;
  let fixture: ComponentFixture<ClimberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
