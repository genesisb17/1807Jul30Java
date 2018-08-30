import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimmodalComponent } from './reimmodal.component';

describe('ReimmodalComponent', () => {
  let component: ReimmodalComponent;
  let fixture: ComponentFixture<ReimmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
