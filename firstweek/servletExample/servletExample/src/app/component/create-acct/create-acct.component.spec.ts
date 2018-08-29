import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAcctComponent } from './create-acct.component';

describe('CreateAcctComponent', () => {
  let component: CreateAcctComponent;
  let fixture: ComponentFixture<CreateAcctComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAcctComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAcctComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
