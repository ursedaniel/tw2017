import {Component, OnInit, Input} from '@angular/core';
import {Book} from "../../../../interfaces/Book";
import {CoursesService} from "../../../../services/courses.service";
import {PagerObject} from "../../../../interfaces/PagerObject";
import {SearchParams} from "../../../../interfaces/SearchParams";

@Component({
  selector: 'acar-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  @Input() courseId: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();

  books: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.coursesService.getBooks(this.courseId,this.searchParamas).subscribe(
      (response) => {
        this.books = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    )
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getBooks();
  }

}
