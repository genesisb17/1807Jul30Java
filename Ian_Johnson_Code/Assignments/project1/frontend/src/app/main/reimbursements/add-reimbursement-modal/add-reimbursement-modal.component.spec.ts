import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddReimbursementModalComponent } from './add-reimbursement-modal.component';

describe('AddReimbursementModalComponent', () => {
  let component: AddReimbursementModalComponent;
  let fixture: ComponentFixture<AddReimbursementModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddReimbursementModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddReimbursementModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
