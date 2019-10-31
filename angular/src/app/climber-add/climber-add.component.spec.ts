import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClimberAddComponent } from './climber-add.component';

describe('ClimberAddComponent', () => {
  let component: ClimberAddComponent;
  let fixture: ComponentFixture<ClimberAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClimberAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClimberAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
