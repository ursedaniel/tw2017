import {Component, OnInit, ViewChild} from '@angular/core';
import {TeachersService} from "../../services/teachers.service";
import {Observable} from "rxjs";
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {Teacher} from "../../interfaces/Teacher";

@Component({
  selector: 'acar-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {

  teachers: any;
  @ViewChild('nameFilter') filterInput: any;
  private filterObs: any;
  @ViewChild('ratingFilter') filterInputRating: any;
  private filterObsRating: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: Teacher = new Teacher();

  constructor(private teachersService: TeachersService) {
  }

  ngOnInit() {
    this.getTeachers();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.name = value;
        this.searchParamas.search = this.searchObject;
        this.getTeachersFiltered();
      });
    this.filterObsRating = Observable.fromEvent(this.filterInputRating.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInputRating.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.rating = value;
        this.searchParamas.search = this.searchObject;
        this.getTeachersFiltered();
      });
  }

  getTeachers() {
    this.teachersService.getTeachers(this.searchParamas).subscribe(
      (response) => {
        this.teachers = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  getTeachersFiltered() {
    this.teachersService.getFilteredTeachers(this.searchParamas).subscribe(
      (response) => {
        this.teachers = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getTeachers();
  }

}
