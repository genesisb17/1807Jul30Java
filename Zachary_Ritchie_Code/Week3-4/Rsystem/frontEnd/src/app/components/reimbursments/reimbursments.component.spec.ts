import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursmentsComponent } from './reimbursments.component';

describe('ReimbursmentsComponent', () => {
  let component: ReimbursmentsComponent;
  let fixture: ComponentFixture<ReimbursmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
