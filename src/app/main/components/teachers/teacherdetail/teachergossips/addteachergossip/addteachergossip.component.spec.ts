/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AddteachergossipComponent } from './addteachergossip.component';

describe('AddteachergossipComponent', () => {
  let component: AddteachergossipComponent;
  let fixture: ComponentFixture<AddteachergossipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddteachergossipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddteachergossipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
