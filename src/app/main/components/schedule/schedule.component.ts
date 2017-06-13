import {Component, OnInit, ViewChild} from '@angular/core';
import {ScheduleService} from "../../services/schedule.service";
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {Schedule} from "../../interfaces/Schedule";
import {Observable} from "rxjs";
import {CoursesService} from "../../services/courses.service";
import {TeachersService} from "../../services/teachers.service";

@Component({
  selector: 'acar-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  schedule: any;
  @ViewChild('dayFilter') filterInput: any;
  private filterObs: any;
  @ViewChild('classFilter') filterInputClass: any;
  private filterObsClass: any;
  @ViewChild('groupFilter') filterInputGroup: any;
  private filterObsGroup: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: Schedule = new Schedule();

  constructor(private scheduleService: ScheduleService, private coursesService: CoursesService, private teachersService: TeachersService) {
  }

  ngOnInit() {
    this.getSchedule();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.day = value;
        this.searchParamas.search = this.searchObject;
        this.getScheduleFiltered();
      });
    this.filterObsClass = Observable.fromEvent(this.filterInputClass.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInputClass.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.class_room = value;
        this.searchParamas.search = this.searchObject;
        this.getScheduleFiltered();
      });
    this.filterObsGroup = Observable.fromEvent(this.filterInputGroup.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInputGroup.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.group = value;
        this.searchParamas.search = this.searchObject;
        this.getScheduleFiltered();
      });
  }

  getSchedule() {
    this.scheduleService.getSchedule(this.searchParamas).subscribe(
      (response) => {
        this.schedule = response.content;
        for (let i = 0; i < this.schedule.length; i++) {
          this.coursesService.getCourse(this.schedule[i].course_id).subscribe(
            (response) => {
              this.schedule[i].course_name = response.name;
            }
          );

          this.teachersService.getTeacher(this.schedule[i].teacher_id).subscribe(
            (response) => {
              this.schedule[i].teacher_name = response.name;
            }
          );
        }
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    )
  }

  getScheduleFiltered() {
    this.scheduleService.getFilteredSchedule(this.searchParamas).subscribe(
      (response) => {
        this.schedule = response.content;
        for (let i = 0; i < this.schedule.length; i++) {
          this.coursesService.getCourse(this.schedule[i].course_id).subscribe(
            (response) => {
              this.schedule[i].course_name = response.name;
            }
          );
          this.teachersService.getTeacher(this.schedule[i].teacher_id).subscribe(
            (response) => {
              this.schedule[i].teacher_name = response.name;
            }
          );
        }
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    )
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getSchedule();
  }

}
