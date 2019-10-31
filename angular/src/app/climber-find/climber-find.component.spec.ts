import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimberFindComponent } from './climber-find.component';

describe('ClimberFindComponent', () => {
  let component: ClimberFindComponent;
  let fixture: ComponentFixture<ClimberFindComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimberFindComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimberFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
