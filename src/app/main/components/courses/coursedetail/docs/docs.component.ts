import {Component, OnInit, Input} from '@angular/core';
import {Doc} from "../../../../interfaces/Doc";
import {CoursesService} from "../../../../services/courses.service";
import {PagerObject} from "../../../../interfaces/PagerObject";
import {SearchParams} from "../../../../interfaces/SearchParams";

@Component({
  selector: 'acar-docs',
  templateUrl: './docs.component.html',
  styleUrls: ['./docs.component.css']
})
export class DocsComponent implements OnInit {

  @Input() courseId: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();

  docs: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getDocs();
  }

  getDocs() {
    this.coursesService.getDocs(this.courseId, this.searchParamas).subscribe(
      (response) => {
        this.docs = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    )
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getDocs();
  }

}
