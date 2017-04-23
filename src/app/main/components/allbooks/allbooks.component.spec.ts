/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AllbooksComponent } from './allbooks.component';

describe('AllbooksComponent', () => {
  let component: AllbooksComponent;
  let fixture: ComponentFixture<AllbooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllbooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllbooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
