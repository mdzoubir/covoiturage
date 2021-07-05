import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormConvComponent } from './form-conv.component';

describe('FormConvComponent', () => {
  let component: FormConvComponent;
  let fixture: ComponentFixture<FormConvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormConvComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormConvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
