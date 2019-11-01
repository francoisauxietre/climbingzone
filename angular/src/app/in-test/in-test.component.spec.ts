import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InTestComponent } from './in-test.component';

describe('InTestComponent', () => {
  let component: InTestComponent;
  let fixture: ComponentFixture<InTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
