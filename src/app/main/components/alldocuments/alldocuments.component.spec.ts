/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AlldocumentsComponent } from './alldocuments.component';

describe('AlldocumentsComponent', () => {
  let component: AlldocumentsComponent;
  let fixture: ComponentFixture<AlldocumentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlldocumentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlldocumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
