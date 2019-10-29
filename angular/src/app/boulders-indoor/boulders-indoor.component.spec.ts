import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BouldersIndoorComponent } from './boulders-indoor.component';

describe('BouldersIndoorComponent', () => {
  let component: BouldersIndoorComponent;
  let fixture: ComponentFixture<BouldersIndoorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BouldersIndoorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BouldersIndoorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
