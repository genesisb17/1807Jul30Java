import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementViewComponent } from './reimbursement-view.component';

describe('ReimbursementViewComponent', () => {
  let component: ReimbursementViewComponent;
  let fixture: ComponentFixture<ReimbursementViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
