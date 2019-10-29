import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BouldersOutdoorComponent } from './boulders-outdoor.component';

describe('BouldersOutdoorComponent', () => {
  let component: BouldersOutdoorComponent;
  let fixture: ComponentFixture<BouldersOutdoorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BouldersOutdoorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BouldersOutdoorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
