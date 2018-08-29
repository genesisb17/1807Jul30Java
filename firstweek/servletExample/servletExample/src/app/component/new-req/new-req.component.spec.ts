import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewReqComponent } from './new-req.component';

describe('NewReqComponent', () => {
  let component: NewReqComponent;
  let fixture: ComponentFixture<NewReqComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewReqComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewReqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
