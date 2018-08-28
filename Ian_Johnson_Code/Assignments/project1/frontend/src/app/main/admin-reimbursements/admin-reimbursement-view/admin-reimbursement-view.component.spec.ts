import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminReimbursementViewComponent } from './admin-reimbursement-view.component';

describe('AdminReimbursementViewComponent', () => {
  let component: AdminReimbursementViewComponent;
  let fixture: ComponentFixture<AdminReimbursementViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminReimbursementViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminReimbursementViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
