import {Component, OnInit, Input} from '@angular/core';
import {Teacher} from "../../../../interfaces/Teacher";
import {TeachersService} from "../../../../services/teachers.service";
import {Rating} from "../../../../interfaces/Rating";

@Component({
  selector: 'acar-teacherinfo',
  templateUrl: './teacherinfo.component.html',
  styleUrls: ['./teacherinfo.component.css']
})
export class TeacherinfoComponent implements OnInit {

  @Input() private teacherId: any;
  rating: Rating = new Rating();

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

  addRating() {
    this.rating.id_user = localStorage.getItem("userId");
    this.rating.teacher_id = this.teacherId;
    this.teachersService.addTeacher(this.teacherId,this.rating).subscribe(
      (succes) => {
        this.getTeacher(this.teacherId);
      }
    )
  }

}
