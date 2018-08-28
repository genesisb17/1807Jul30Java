import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementDetailsModalComponent } from './reimbursement-details-modal.component';

describe('ReimbursementDetailsModalComponent', () => {
  let component: ReimbursementDetailsModalComponent;
  let fixture: ComponentFixture<ReimbursementDetailsModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementDetailsModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementDetailsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
