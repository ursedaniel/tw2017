/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { CoursegossipsComponent } from './coursegossips.component';

describe('CoursegossipsComponent', () => {
  let component: CoursegossipsComponent;
  let fixture: ComponentFixture<CoursegossipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursegossipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursegossipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
