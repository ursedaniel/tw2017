import {Component, OnInit, ViewChild} from '@angular/core';
import {TeachersService} from "../../services/teachers.service";
import {Observable} from "rxjs";

@Component({
  selector: 'acar-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {

  teachers: any;
  @ViewChild('nameFilter') filterInput: any;
  private filterObs: any;

  constructor(private teachersService: TeachersService) {
  }

  ngOnInit() {
    this.getTeachers();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.getTeachersFiltered(value);
      });
  }

  getTeachers() {
    this.teachersService.getTeachers().subscribe(
      (response) => {
        this.teachers = response.content;
      }
    );
  }

  getTeachersFiltered(value) {
    this.teachersService.getFilteredTeachers(value).subscribe(
      (response) => {
        this.teachers = response.content;
      }
    );
  }

}
