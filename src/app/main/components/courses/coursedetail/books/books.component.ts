import {Component, OnInit, Input} from '@angular/core';
import {Book} from "../../../../interfaces/Book";
import {CoursesService} from "../../../../services/courses.service";

@Component({
  selector: 'acar-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  @Input() courseId: any;

  books: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.coursesService.getBooks(this.courseId).subscribe(
      (response) => {
        this.books = response.content;
      }
    )
  }

}
