import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewreimComponent } from './viewreim.component';

describe('ViewreimComponent', () => {
  let component: ViewreimComponent;
  let fixture: ComponentFixture<ViewreimComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewreimComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewreimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
