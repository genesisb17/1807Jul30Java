import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbAddComponent } from './reimb-add.component';

describe('ReimbAddComponent', () => {
  let component: ReimbAddComponent;
  let fixture: ComponentFixture<ReimbAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
