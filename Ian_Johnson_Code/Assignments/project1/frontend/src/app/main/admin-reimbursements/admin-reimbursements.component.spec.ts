import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminReimbursementsComponent } from './admin-reimbursements.component';

describe('AdminReimbursementsComponent', () => {
  let component: AdminReimbursementsComponent;
  let fixture: ComponentFixture<AdminReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
