import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbViewComponent } from './reimb-view.component';

describe('ReimbViewComponent', () => {
  let component: ReimbViewComponent;
  let fixture: ComponentFixture<ReimbViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
