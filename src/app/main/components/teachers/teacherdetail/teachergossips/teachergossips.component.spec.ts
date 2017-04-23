/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TeachergossipsComponent } from './teachergossips.component';

describe('TeachergossipsComponent', () => {
  let component: TeachergossipsComponent;
  let fixture: ComponentFixture<TeachergossipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeachergossipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeachergossipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
