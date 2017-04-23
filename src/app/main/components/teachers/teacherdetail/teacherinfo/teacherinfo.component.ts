import {Component, OnInit, Input} from '@angular/core';
import {Teacher} from "../../../../interfaces/Teacher";
import {TeachersService} from "../../../../services/teachers.service";

@Component({
  selector: 'acar-teacherinfo',
  templateUrl: './teacherinfo.component.html',
  styleUrls: ['./teacherinfo.component.css']
})
export class TeacherinfoComponent implements OnInit {

  @Input() private teacherId: any;

  teacher: Teacher = new Teacher();

  constructor(private teachersService: TeachersService) { }

  ngOnInit() {
    this.getTeacher(this.teacherId);
  }

  getTeacher(id) {
    this.teachersService.getTeacher(id).subscribe(
      (response) => {
        this.teacher = response;
        console.log(this.teacher);
      }
    )
  }

}
